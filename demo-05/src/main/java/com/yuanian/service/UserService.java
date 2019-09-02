package com.yuanian.service;

import com.yuanian.Mapper.UserMapper;
import com.yuanian.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserMapper userMapper;

    public void addUser() throws ParseException{
        User user=new User();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        user.setUserCode("10");
        user.setUserName("王五");
        user.setDepartment("华南技术开发部");
        Date date=sdf.parse("2019-08-19");
        user.getHireDate(new java.sql.Date(new Date().getTime()));

        System.out.println(user);
        userMapper.add(user);
    }

    public void addUserMsg(User user){
        userMapper.add(user);

    }

    public User findUser(String userCode){
        return userMapper.selectByUserCode(userCode);
    }

    public List<User> showAll(String starttime,String lasttime){

        List<User> list=new ArrayList<>();
        list=userMapper.selectByHireDate(starttime, lasttime);
        // System.out.println(list);
        return list;
    }

    public void deleteUser(){
        userMapper.deleteByUserCode("1");
    }

//    public Staff upStaff(){
//
//    }
}
