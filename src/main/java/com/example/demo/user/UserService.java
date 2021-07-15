package com.example.demo.user;

import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Map<String,Object> login(User user){
        return userMapper.loginUser(user);
    }
    public int register(User user){
        return userMapper.registerUser(user);
    }
}