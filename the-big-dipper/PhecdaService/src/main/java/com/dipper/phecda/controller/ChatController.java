package com.dipper.phecda.controller;

import com.dipper.phecda.entity.*;
import com.dipper.phecda.redis.RedisUtil;
import com.dipper.phecda.service.BaseService;
import com.dipper.phecda.utils.RedisConst;
import com.dipper.proto.constant.RpcCommonConstant;
import com.dipper.proto.rpc.*;
import com.dipper.proto.utils.JSONParserUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/chat")
@Controller
public class ChatController {

    @Value("${image.server}")
    private String imageServer;

    @Resource(name = RpcCommonConstant.USER)
    private BaseService userService;

    @Resource(name = RpcCommonConstant.FRIEND_TYPE)
    private BaseService friendTypeService;

    @Resource(name = RpcCommonConstant.GROUP_USER)
    private BaseService groupUserService;

    @Resource(name = RpcCommonConstant.FRIEND)
    private BaseService friendService;

    @Resource(name = RpcCommonConstant.GROUP)
    private BaseService groupService;

    @RequestMapping(value = "getInitList", produces = "text/plain; charste=utf-8")
    @ResponseBody
    public String getInitList(int userId) {
        try {
            UserPro build = UserPro.newBuilder().setId(userId).build();
            UserPro user = (UserPro) userService.selectOne(build);
            //User user = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(message), User.class);
            MVUser mvUser = new MVUser();
            mvUser.setId(user.getId());
            if (user.getAvatar() == null || user.getAvatar().equals("")) {
                mvUser.setAvatar(imageServer + "undefined");
            } else {
                System.out.println(imageServer);
                mvUser.setAvatar(imageServer + user.getAvatar());
            }

            mvUser.setSign(user.getSign());
            mvUser.setUsername(user.getNickName());
            //获取redis中的用户在线状态
            String redisKey = userId + RedisConst.USER_STATUS;
            RedisUtil.set(redisKey, RedisConst.STATUS_ONLINE);
            mvUser.setStatus("online");
            MVInit mvInit = new MVInit();
            MVData data = new MVData();
            data.setMine(mvUser);
            mvInit.setData(data);
            List<MVFriend> mvFriendList = new ArrayList<>();
            List<FriendTypePro> list = friendTypeService.selectList(FriendTypePro.newBuilder().setUserId(userId).build());
            if (list == null) {
                FriendTypePro friendTypePro = FriendTypePro.newBuilder().setUserId(userId).setIsDefault(1).setTypeName("好友").build();
                FriendTypePro save = (FriendTypePro) friendTypeService.save(friendTypePro);//如果没有默认分组，则初始化分组
                MVFriend mvFriend = new MVFriend();
                mvFriend.setGroupname("好友");
                mvFriend.setOnline(0);
                mvFriend.setId(save.getId());
                mvFriendList.add(mvFriend);
            } else {
                try {
                    for (int i = 0; i < list.size(); i++) {
                        MVFriend mvFriend = new MVFriend();
                        mvFriend.setGroupname(list.get(i).getTypeName());
                        mvFriend.setId(list.get(i).getId());
                        int typeId = list.get(i).getId();
                        FriendPro friendPro = FriendPro.newBuilder().setUserId(userId).setTypeId(typeId).build();
                        List<FriendPro> friendList = friendService.selectList(friendPro);
                        List<MVUser> mvUserList = new ArrayList<>();
                        int onlineNum = 0;
                        for (int j = 0; j < friendList.size(); j++) {
                            FriendPro friendPro1 = friendList.get(j);
                            MVUser smvUser = new MVUser();
                            UserPro userPro = (UserPro) userService.selectOne(UserPro.newBuilder().setId(friendPro1.getFriendId()).build());
                            smvUser.setAvatar(imageServer + userPro.getAvatar());
                            smvUser.setSign(userPro.getSign());
                            smvUser.setUsername(userPro.getNickName());
                            smvUser.setId(friendPro1.getFriendId());
                            onlineNum++;
                            //获取redis中的用户在线状态
                            redisKey = friendList.get(j).getFriendId() + RedisConst.USER_STATUS;
                            if (RedisUtil.exists(redisKey)) {
                                smvUser.setStatus(RedisUtil.get(redisKey).toString());
                            } else {
                                smvUser.setStatus("offline");
                            }
                            mvUserList.add(smvUser);
                        }
                        mvFriend.setOnline(onlineNum);
                        mvFriend.setList(mvUserList);
                        mvFriendList.add(mvFriend);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            data.setFriend(mvFriendList);
            //获取我加入的群的列表

            List<GroupUserPro> groupList = groupUserService.selectList(GroupUserPro.newBuilder().setUserId(userId).build());
            List<MVGroup> glist = new ArrayList<>();
            if (groupList != null) {
                for (int k = 0; k < groupList.size(); k++) {
                    GroupPro message1 = (GroupPro) groupService.selectOne(GroupPro.newBuilder().setId(groupList.get(k).getGroupId()).build());
                    MVGroup sgroup = new MVGroup();
                    sgroup.setGroupname(message1.getGroupName());
                    sgroup.setId(message1.getId());
                    sgroup.setAvatar(message1.getAvatar());
                    glist.add(sgroup);
                }
                data.setGroup(glist);
            }
            mvInit.setData(data);
            return JSONParserUtils.object2JsonString(mvInit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
