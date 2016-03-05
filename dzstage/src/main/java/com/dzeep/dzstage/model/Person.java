package com.dzeep.dzstage.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by fighting on 15/10/7.
 * 该类为用户，有账号、性别、邮箱、密码等属性，与管理的版面为多对多
 */
@Entity         //实体类配置
@Table(name = "account")          //表格配置
public class Person extends BaseBean {
    private String account;
    private String password;
    private String sex;
    private String name;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date birthday;
    private String email;
    private String ipCreated;           //注册时的邮箱地址

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateLastCreated;       //最后一次登录时间
    private String ipLastCreated;       //最后一次登录ip

    @ManyToMany(mappedBy = "administrators")        //多对多属性
    private Set<Board> boardAdministrated = new HashSet<Board>();       //用户管理的版面

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIpCreated() {
        return ipCreated;
    }

    public void setIpCreated(String ipCreated) {
        this.ipCreated = ipCreated;
    }

    public Date getDateLastCreated() {
        return dateLastCreated;
    }

    public void setDateLastCreated(Date dateLastCreated) {
        this.dateLastCreated = dateLastCreated;
    }

    public String getIpLastCreated() {
        return ipLastCreated;
    }

    public void setIpLastCreated(String ipLastCreated) {
        this.ipLastCreated = ipLastCreated;
    }

    public Set<Board> getBoardAdministrated() {
        return boardAdministrated;
    }

    public void setBoardAdministrated(Set<Board> boardAdministrated) {
        this.boardAdministrated = boardAdministrated;
    }
}
