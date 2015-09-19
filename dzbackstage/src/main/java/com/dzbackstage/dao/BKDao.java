package com.dzbackstage.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by tb on 15/9/18.
 */
public abstract class BKDao<T> extends HibernateDaoSupport{
    abstract public List<T> findAll();

    abstract public void save(T t);

    abstract public void remove(int id);

    abstract public T find(int id);

}
