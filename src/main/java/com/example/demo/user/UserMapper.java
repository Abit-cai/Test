package com.example.demo.user;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

//@Repository(value="UserMapper")
@Mapper
public interface UserMapper {
    public Map<String,Object> loginUser(User user);
    public int registerUser(User user);
}

