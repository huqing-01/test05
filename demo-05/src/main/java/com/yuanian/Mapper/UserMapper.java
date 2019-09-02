package com.yuanian.Mapper;

import com.yuanian.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
//@Repository
public interface UserMapper {

    //增
    @Insert("insert into user(userCode,userName,department,hireDate) values(#{userCode},#{userName},#{department},#{hireDate})")
    int add(User user);

    //查--根据userCode查
    @Select("select * from user where userCode = #{userCode}")
    public User selectByUserCode(String userCode);

    //查--根据hireDate查
    @Select("select *from user where hireDate = #{HireCode}")
    List<User> selectByHireDate(String starttime , String lasttime);

    //删
    @Delete("delete from user where userCode = #{userCode}")
    int deleteByUserCode(String userCode);

    //改
    @Update("update user set userName=#{userName} department=#{department} hireDate=#{hireDate} where userCode = #{userCode}")
    public User updateUser(String userCode);
}
