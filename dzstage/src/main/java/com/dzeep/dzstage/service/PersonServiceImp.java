package com.dzeep.dzstage.service;

import com.dzeep.dzframe.utils.MD5Utils;
import com.dzeep.dzstage.model.Person;

import java.util.List;

/**
 * Created by alan on 15/10/7.
 * 用户服务层
 */
public class PersonServiceImp<T extends Person> extends ServiceImp<T> implements IPersonService<T> {
    @Override
    public T findPersonByAccount(String account) {
        List<T> persons = this.getDao().createQuery("SELECT p.* FROM account p WHERE lower(p.account) = lower(:account) AND deleted=false")
                .addEntity(Person.class)
                .setParameter("account", account.trim())
                .list();
        if (persons.size()>0) return persons.get(0);
        return null;
    }

    @Override
    public T getPerson(String account, String password) {
        List persons = this.dao.createQuery("SELECT p.* FROM account p WHERE p.account = :account AND p.password = :password AND deleted=false").setParameter("account", account).setParameter("password",MD5Utils.md5(password)).list();
        if (persons.size() > 0) return (T) persons.get(0);
        return null;
    }

    @Override
    public void create(T person) {
        if (findPersonByAccount(person.getAccount()) != null){      //检查用户是否存在
            throw new RuntimeException("账号："+person.getAccount()+"已经存在");
        }
        person.setPassword(MD5Utils.md5(person.getPassword()));
        this.dao.create(person);
    }
}
