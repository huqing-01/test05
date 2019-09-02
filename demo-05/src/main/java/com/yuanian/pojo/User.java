package com.yuanian.pojo;

import java.sql.Date;

public class User {
    private int id;
    private String userCode;             //员工的工号
    private String userName;             //员工姓名
    private String department;           //员工部门
    private java.sql.Date hireDate;

    public User(int id, String userCode, String userName, String department, Date hireDate) {
        this.id = id;
        this.userCode = userCode;
        this.userName = userName;
        this.department = department;
        this.hireDate = hireDate;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getHireDate(Date date) {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", department='" + department + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}