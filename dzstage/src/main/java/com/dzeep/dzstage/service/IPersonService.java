package com.dzeep.dzstage.service;

import com.dzeep.dzstage.model.Person;

/**
 * Created by alan on 15/10/7.
 */
public interface IPersonService<T extends Person> extends IService<T> {

    /**
     * 根据用户名查询用户信息
     * @param account
     * @return
     */
    public T findPersonByAccount(String account);

    /**
     * 根据用户名和密码获取用户信息
     * @param account
     * @param password
     * @return
     */
    public T getPerson(String account,String password);
}
