package com.dzbackstage.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import java.util.Date;

/**
 * Created by tb on 15/9/17.
 */

@Entity
@Table(name = "account")
public class UserInfo {
    /** 用户id编号 */
    @Id
    @GeneratedValue (generator = "increment")
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

    public UserInfo(String title, Date date) {
        // for application use, to create new events
        this.userName = title;
        this.regTime = date;
        this.password = "123456";
        this.email = "adfadf@email.com";
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
