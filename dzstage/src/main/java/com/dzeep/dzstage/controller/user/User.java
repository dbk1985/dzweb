package com.dzeep.dzstage.controller.user;

import com.dzeep.dzframe.utils.MD5Utils;
import com.dzeep.dzstage.controller.DZAction;
import com.dzeep.dzstage.model.Person;
import com.dzeep.dzstage.service.PersonServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by alan on 15/10/7.
 * 用户管理
 */
public class User extends DZAction {
    private Person person;
    private String password;
    private PersonServiceImp<Person> personServiceImp;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPassword() {
        return password;
    }

    public PersonServiceImp<Person> getPersonServiceImp() {
        return personServiceImp;
    }

    public void setPersonServiceImp(PersonServiceImp<Person> personServiceImp) {
        this.personServiceImp = personServiceImp;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //用户注册
    public String regist(){
        setTitle("用户注册");
        return SUCCESS;
    }
    // 用户登录
    public String login(){
        person = new Person();
        String userName = getRequest().getParameter("account");
        String password = getRequest().getParameter("password");
        if (userName == null || password == null){
            return LOGIN;
        }
        Person loginPerson = personServiceImp.findPersonByAccount(userName);
        if (loginPerson == null){
            return LOGIN;
        }
        if (!loginPerson.getPassword().equals(MD5Utils.md5(password))){
            return LOGIN;
        }
        HttpServletRequest request = getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("user",userName);
        return "info";
    }

    public String info(){
        return SUCCESS;
    }
    public String ajaxValidate(){
        return SUCCESS;
    }

    @Override
    public String list() {
        return null;
    }
}
