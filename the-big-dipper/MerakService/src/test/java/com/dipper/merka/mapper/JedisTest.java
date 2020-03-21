package com.dipper.merka.mapper;

import com.dipper.merak.MerakServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MerakServiceApplication.class)
public class JedisTest {

    @Autowired
    private ValueOperations value;

    private static final int TIMEOUT = 10 * 1000;//超时时间 10s

    @Test
    public void test() {
        value.set("1", "1");
        String s = (String) value.get("1");
        System.out.println(s);
    }
}
