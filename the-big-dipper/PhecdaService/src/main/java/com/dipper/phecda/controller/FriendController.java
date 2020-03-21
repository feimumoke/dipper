package com.dipper.phecda.controller;

import com.dipper.phecda.service.BaseService;
import com.dipper.proto.constant.RpcCommonConstant;
import com.dipper.proto.entity.User;
import com.dipper.proto.rpc.FriendPro;
import com.dipper.proto.rpc.FriendTypePro;
import com.dipper.proto.rpc.UserPro;
import com.dipper.proto.utils.JSONParserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/friend")
public class FriendController {

    @Resource(name = RpcCommonConstant.USER)
    private BaseService userService;

    @Resource(name = RpcCommonConstant.FRIEND_TYPE)
    private BaseService riendTypeService;

    @Resource(name = RpcCommonConstant.GROUP_USER)
    private BaseService groupUserService;

    @Resource(name = RpcCommonConstant.FRIEND)
    private BaseService friendService;

    @Resource(name = RpcCommonConstant.FRIEND_TYPE)
    private BaseService friendTypeService;

    @RequestMapping(value="/init/{userId}",produces = "text/plain; charset=utf-8")

    @ResponseBody
    public String init(@PathVariable("userId")int userId){
        UserPro.Builder builder = UserPro.newBuilder().setId(userId);
        UserPro user = (UserPro) userService.selectOne(builder.build());
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> mine = new HashMap<>();
        mine.put("username", user.getNickName());
        mine.put("id", user.getId());
        mine.put("status", "online");
        mine.put("sign", user.getSign());
        mine.put("avatar", user.getAvatar());
        map.put("mine", mine);
        return JSONParserUtils.object2JsonString(map);
    }

    @RequestMapping(value = "searchFriendById",produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String searchFriendById(String friendId){
        System.out.println("friendId:"+friendId);
        FriendPro.Builder builder = FriendPro.newBuilder().setFriendId(Integer.valueOf(friendId));
        List<FriendPro> list = friendService.selectList(builder.build());
        List<User> userList=new ArrayList<>();
        list.forEach(u->{
            userService.selectOne(UserPro.newBuilder().setId(u.getFriendId()).build());
        });
        return null;
    }


    @RequestMapping(value = "searchFriendType",produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String searchFriendTypeId(String userId){
        System.out.println("searchFriendType:"+userId);
        List<FriendTypePro> list = friendTypeService.selectList(FriendTypePro.newBuilder().setUserId(Integer.valueOf(userId)).build());
        return JSONParserUtils.object2JsonString(list);
    }



}
