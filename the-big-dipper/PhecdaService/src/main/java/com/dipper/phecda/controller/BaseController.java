package com.dipper.phecda.controller;

import com.dipper.phecda.utils.HttpUtil;
import com.dipper.proto.entity.User;

import javax.servlet.http.HttpSession;

public abstract class BaseController {

    protected static final String token_key = "user";

    /**
     * 获取当前用户
     *
     * @return
     */
    protected User getUser() {
        HttpSession session = HttpUtil.getSession();
        Object obj = session.getAttribute(token_key);
        if (obj instanceof User) {
            return (User) obj;
        }
        return null;
    }

    /**
     * 是否登录
     *
     * @return
     */
    protected boolean isLogin() {
        return HttpUtil.getSession().getAttribute(token_key) instanceof User;
    }
}
