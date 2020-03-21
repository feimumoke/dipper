package com.dipper.phecda.service;

import com.dipper.proto.constant.RpcCommonConstant;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceTest {

    @Resource(name = RpcCommonConstant.USER)
    private BaseService userService;


    public void test(){

    }
}
