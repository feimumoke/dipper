package com.dipper.phecda.controller;

import com.dipper.phecda.service.BaseService;
import com.dipper.phecda.utils.HttpUtil;
import com.dipper.phecda.utils.RespResult;
import com.dipper.proto.constant.RpcCommonConstant;
import com.dipper.proto.entity.User;


import com.dipper.proto.rpc.UserPro;
import com.dipper.proto.utils.JSONParserUtils;
import com.dipper.proto.utils.ProtobufUtils;
import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RequestMapping
@Controller
public class UseController extends BaseController {

    @Resource(name = RpcCommonConstant.USER)
    private BaseService userService;

    @RequestMapping({"/index", "", "/"})
    public String index() {
        return isLogin() ? "/index" : "redirect:/login";
    }

    @GetMapping("login")
    public Object login() {
        ModelAndView view = new ModelAndView();
        view.setViewName("febs/login");
        return view;
    }


    @GetMapping("febs/views/layout")
    public String layout() {
        return "febs/views/layout";
    }

    @GetMapping("febs/views/user/useradd")
    public String useradd() {
        return "febs/views/user/useradd";
    }

    @PostMapping("user/add")
    @ResponseBody
    public RespResult useradd(@RequestBody User user) {
        System.out.println(user);
        List<UserPro> list = userService.selectAll();
        long count = list.stream().filter(u -> u.getUserName().equals(user.getUserName())).count();
        if (count > 0) {
            return new RespResult(400, "用户名不能重复");
        }
        try {
            UserPro userPro = ProtobufUtils.objectToPf(user, UserPro.newBuilder().setGender(user.getGender()));
            userService.save(userPro);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return new RespResult().success();
    }


    @PostMapping("/login")
    @ResponseBody
    public RespResult<User> printUserInfo(@RequestParam("userName") String username, @RequestParam("password") String password) {
        System.out.println("username: " + username + ", password: " + password);
        UserPro userPro = UserPro.newBuilder().setUserName(username).setPassword(password).build();
        UserPro realUser = (UserPro) userService.selectOne(userPro);
        RespResult<User> result = new RespResult<>();
        if (realUser != null) {
            User user = null;
            try {
                user = JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(realUser), User.class);
                System.out.println(user);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
            result.setResCode(200);
            result.setResData(user);
            HttpUtil.getSession().setAttribute(token_key, user);
        } else {
            result.setResCode(400);
            result.setResInfo("username or password is not right!");
        }
        return result;
    }

    @GetMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @GetMapping("febs/views/index")
    public String mainIndex() {
        return "febs/views/index";
    }


    @GetMapping("/user/all")
    @ResponseBody
    public List<User> getAllUser() {
        List<UserPro> all = userService.selectAll();
        ArrayList<User> list = new ArrayList<>();
        all.forEach(u -> {
            try {
                list.add(JSONParserUtils.entry2Object(ProtobufUtils.pfToJson(u), User.class));
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        });
        return list;
    }


}
