package com.dipper.phecda.service;

import com.dipper.phecda.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    @Test
    public void test(){
        boolean exists = RedisUtil.exists("1");
        System.out.println(exists);
        boolean b = RedisUtil.setIfAbsent("1", "1");
        System.out.println(b);
        System.out.println(RedisUtil.setIfAbsent("1","2"));
        System.out.println(RedisUtil.exists("1"));
        System.out.println(RedisUtil.get("1"));
    }
}
