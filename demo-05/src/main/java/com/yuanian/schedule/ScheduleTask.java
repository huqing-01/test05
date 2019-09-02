package com.yuanian.schedule;

import com.yuanian.Mapper.UserMapper;
import com.yuanian.pojo.User;
import com.yuanian.service.UserService;
import com.yuanian.utils.GetUrl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleTask {

    @Autowired
    private UserService userService;

    @Autowired
    UserMapper userMapper;

    @Scheduled(cron = "* * 1 * * ?")
    public void reportCurrentByCron() throws ParseException {
        GetUrl gu=new GetUrl();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String content= gu.result();
        System.out.println(content);
        //System.out.println(content);
        // JSONObject json=JSONObject.fromObject(content);
        List<User> list=new ArrayList<>();
        JSONArray msg=JSONArray.fromObject(content);
        for(int i=0;i<msg.size();i++){
            JSONObject json = msg.getJSONObject(i);
            User user=new User();
            Date date=sdf.parse(json.getString("hireDate"));
            user.setUserName(json.getString("userName"));
            user.setUserCode(json.getString("userCode"));
            user.setDepartment(json.getString("department"));
            user.setHireDate(new java.sql.Date(date.getTime()));

            list.add(user);
            userService.addUserMsg(user);
        }
        System.out.println(list);
    }
}
