package com.dzbackstage.model;

import java.util.Date;
/**
 * Created by tb on 15/9/17.
 */
public class UserInfo {
    /** 用户id编号 */
    private long id;
    /** 用户名 */
    private String userName;
    /** 用户密码 */
    private String password;
    /** 邮箱地址 */
    private String email;
    /** 注册时间 */
    private Date regTime;

    public UserInfo() {
        // this form used by Hibernate
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getRegTime() {
        return regTime;
    }
    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }
}
