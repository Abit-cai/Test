package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.ReturnMessage;
import com.example.demo.pojo.User;
import com.example.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;


    @CrossOrigin
    @RequestMapping(value="/login",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody User user){
        ReturnMessage returnMessage=new ReturnMessage();
        Map<String, Object> result= userService.login(user);
        if (null == result) {
            returnMessage.setExecuteStatus("0");
            returnMessage.setExecuteMsg("用户未注册");
        } else {
            if (!user.getPassword().equals(result.get("password"))) {
                returnMessage.setExecuteStatus("0");
                returnMessage.setExecuteMsg("密码错误");
            } else {
                returnMessage.setExecuteStatus("1");
                returnMessage.setExecuteMsg("登录成功");
                returnMessage.setInfo(result);
            }
        }
        return JSONObject.toJSONString(returnMessage);
    }
    @RequestMapping(value="/register",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String register(@RequestBody User user){
        ReturnMessage returnMessage=new ReturnMessage();
        try {
            userService.register(user);
        } catch (Exception e) {
            returnMessage.setExecuteStatus("0");
            returnMessage.setExecuteMsg("注册失败.该名字已被使用");
            return JSONObject.toJSONString(returnMessage);
        }
        returnMessage.setExecuteStatus("1");
        returnMessage.setExecuteMsg("注册成功.请立刻登录");
        return JSONObject.toJSONString(returnMessage);
    }
}
