package com.dipper.phecda.websocket;

import com.alibaba.fastjson.JSONObject;
import com.dipper.phecda.redis.RedisUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    private static ConcurrentHashMap<Integer, Channel> onlineUser = new ConcurrentHashMap<>();

    private static ChatHandler chatHandler;

    @Autowired
    private MessageHandler messageHandler;

    @PostConstruct
    private void init() {
        chatHandler = this;
        chatHandler.messageHandler = this.messageHandler;
    }

    public static ChannelGroup getChannels() {
        return channels;
    }

    public static ConcurrentHashMap<Integer, Channel> getOnlineUser() {
        return onlineUser;
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String text = msg.text();
        Channel channel = ctx.channel();
        JSONObject message = JSONObject.parseObject(text);
        chatHandler.messageHandler.dealWithMessage(channel, message);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.channel().close();
        channels.remove(ctx.channel());
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        String channelId = ctx.channel().id().asShortText();
        System.out.println("客户端加入:" + channelId);
        channels.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        String channelId = ctx.channel().id().asShortText();
        System.out.println("客户端离开:" + channelId);
    }
}
