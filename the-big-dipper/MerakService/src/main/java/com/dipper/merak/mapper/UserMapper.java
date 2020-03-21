package com.dipper.merak.mapper;

import com.dipper.proto.entity.User;

import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper extends BaseMapper<User, Integer> {

}
