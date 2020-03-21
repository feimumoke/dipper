package com.dipper.phecda.service;

import com.dipper.proto.constant.RpcCommonConstant;
import com.dipper.proto.rpc.FriendPro;
import com.dipper.proto.rpc.MessageType;
import com.dipper.proto.rpc.UserPro;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseServiceConfiguration {

    @Bean(autowire = Autowire.BY_NAME, value = RpcCommonConstant.USER)
    public BaseService userBaseService() {
        return new BaseService<UserPro>(MessageType.USER);
    }

    @Bean(autowire = Autowire.BY_NAME, value = RpcCommonConstant.FRIEND)
    public BaseService firendBaseService() {
        return new BaseService<FriendPro>(MessageType.FRIEND);
    }


    @Bean(autowire = Autowire.BY_NAME, value = RpcCommonConstant.FRIEND_MESSAGE)
    public BaseService friendMessageBaseService() {
        return new BaseService<UserPro>(MessageType.FRIEND_MESSAGE);
    }

    @Bean(autowire = Autowire.BY_NAME, value = RpcCommonConstant.GROUP)
    public BaseService groupBaseService() {
        return new BaseService<UserPro>(MessageType.GROUP);
    }

    @Bean(autowire = Autowire.BY_NAME, value = RpcCommonConstant.GROUP_USER)
    public BaseService groupUserBaseService() {
        return new BaseService<UserPro>(MessageType.GROUP_USER);
    }

    @Bean(autowire = Autowire.BY_NAME, value = RpcCommonConstant.FRIEND_TYPE)
    public BaseService friendTypeBaseService() {
        return new BaseService<UserPro>(MessageType.FRIEND_TYPE);
    }
}
