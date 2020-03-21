package com.dipper.merka.mapper;


import com.dipper.merak.MerakServiceApplication;
import com.dipper.merak.mapper.UserMapper;
import com.dipper.proto.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MerakServiceApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void  getAllUser(){
        User user1 = new User();
        user1.setUserName("jk");
        user1.setPassword("jk");
        Example<User> example=Example.of(user1);
        Optional<User> one = userMapper.findOne(example);
        System.out.println(one.get());
    }
}
