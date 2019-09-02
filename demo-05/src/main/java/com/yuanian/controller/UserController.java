package com.yuanian.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yuanian.pojo.User;
import com.yuanian.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    //注入service
    @Autowired
    private UserService userService;

    @PostMapping("user/{userCode}")
    public User ShowMsg(@PathVariable(value = "userCode") String userCode){
        System.out.println(userCode);
        return userService.findUser(userCode);
    }

    @GetMapping("insert")
    public void insertUser() throws ParseException {
        userService.addUser();
    }

    @GetMapping("delete")
    public void delUser(){
        userService.deleteUser();
    }

    @PostMapping("getdata")
    public List<User> gerDate(@RequestParam(value="startTime") String starttime,
                               @RequestParam(value="lastTime") String lasttime){

//        System.out.println(starttime);
//        System.out.println(lasttime);
        return userService.showAll(starttime,lasttime);
    }
}
