package com.dipper.phecda.websocket;

import com.alibaba.fastjson.JSONObject;
import com.dipper.phecda.redis.RedisUtil;
import com.dipper.phecda.service.BaseService;
import com.dipper.phecda.utils.RedisConst;
import com.dipper.proto.constant.RpcCommonConstant;
import com.dipper.proto.rpc.FriendMessagePro;
import com.dipper.proto.utils.JSONParserUtils;
import com.google.protobuf.Message;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Component
public class MessageHandler {

    private static final Executor DB_EXECUTOR = Executors.newSingleThreadExecutor();


    @Resource(name = RpcCommonConstant.FRIEND_MESSAGE)
    private BaseService friendMessageService;


    public void dealWithMessage(Channel channel, JSONObject message) {
        System.out.println("{}:" + message);
        String action = message.getJSONObject("to").getString("type");
        if (action.equals("login")) {
            Integer userId = Integer.valueOf(message.getString("userId"));
            ChatHandler.getOnlineUser().put(userId, channel);
        } else if (action.equals("friend")) {
            handerFriendMessage(channel, message);
        } else if (action.equals("close")) {
            Integer userId = Integer.valueOf(message.getString("userId"));
            RedisUtil.set(userId + RedisConst.USER_STATUS, RedisConst.STATUS_OFFLINE);
        }
    }

    private void handerFriendMessage(Channel channel, JSONObject message) {
        int toId = message.getJSONObject("to").getInteger("id");
        Channel receiverChannel = ChatHandler.getOnlineUser().get(toId);
        JSONObject friendMessage = loadFriendMessage(message);
        FriendMessagePro.Builder messagePro = loadFriendMessagePro(message);
        if (receiverChannel == null) {
            storeFriendMessage(messagePro, false);
        } else {
            Channel findChannel = ChatHandler.getChannels().find(receiverChannel.id());
            if (findChannel != null) {
                receiverChannel.writeAndFlush(new TextWebSocketFrame(JSONParserUtils.object2JsonString(friendMessage)));
                storeFriendMessage(messagePro, true);
            } else {
                storeFriendMessage(messagePro, false);
            }
        }
    }

    private JSONObject loadFriendMessage(JSONObject message) {
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date date = new Date();
        String time = df.format(date);
        message.put("time", time);
        JSONObject toMessage = new JSONObject();
        toMessage.put("avatar", message.getJSONObject("mine").getString("avatar"));
        toMessage.put("content", message.getJSONObject("mine").getString("content"));
        toMessage.put("timestamp", date.getTime());
        toMessage.put("time", time);
        toMessage.put("mine", false);
        toMessage.put("type", message.getJSONObject("to").getString("type"));
        toMessage.put("username", message.getJSONObject("mine").getString("username"));
        toMessage.put("id", message.getJSONObject("mine").getIntValue("id"));
        return toMessage;
    }

    private FriendMessagePro.Builder loadFriendMessagePro(JSONObject message) {
        FriendMessagePro.Builder builder = FriendMessagePro.newBuilder();
        builder.setFromUserId(message.getJSONObject("mine").getIntValue("id"));
        builder.setToUserId(message.getJSONObject("to").getIntValue("id"));
        builder.setContent(message.getJSONObject("mine").getString("content"));
        builder.setIsDel(0);
        builder.setIsBack(0);
        builder.setSendTime(message.getString("time"));
        return builder;
    }

    private void storeFriendMessage(FriendMessagePro.Builder builder, boolean isRead) {
        int read = isRead ? 1 : 0;
        builder.setIsRead(read);
        DB_EXECUTOR.execute(() -> {
            Message save = friendMessageService.save(builder.build());
            System.out.println(save);
        });
    }
}
