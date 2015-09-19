package com.dzeep.dzstage.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by fighting on 15/9/13.
 */
@Entity
@Table(name = "user")
public class UserInfo {
    /** 用户id编号 */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private long id;
    /** 用户名 */
    @Column(name = "user_name")
    private String userName;
    /** 用户密码 */
    private String password;
    /** 邮箱地址 */
    private String email;
    /** 注册时间 */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reg_time")
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
    @Override
    public String toString() {
        return "userInfo===>userName:"+getUserName();
    }
}
