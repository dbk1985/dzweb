package com.dzeep.dzstage.dao;

import org.hibernate.SQLQuery;

import java.util.List;

/**
 * Created by alan on 15/10/7.
 */
public interface IDao<T> {
    /**
     * 根据实体id查询实体
     * @param tClass
     * @param id        实体id
     * @return
     */
    public T find(Class<T> tClass,int id);

    /**
     * 创建实体
     * @param baseBean
     */
    public void create(T baseBean);

    /**
     * 保存实体
     * @param baseBean
     */
    public void save(T baseBean);

    /**
     * 删除实体
     * @param baseBean
     */
    public void delete(T baseBean);

    /**
     * 查询实体
     * @param sql
     * @return
     */
    public List<T> list(String sql);

    /**
     * 查询总数
     * @param sql
     * @param params
     * @return
     */
    public int getTotalCount(String sql,Object... params);

    /**
     * 查询某页实体
     * @param sql
     * @param firstResult
     * @param maxSize
     * @param params
     * @return
     */
    public List<T> list(String sql,int firstResult,int maxSize,Object... params);

    /**
     * 创建Query对象
     * @param sql
     * @return
     */
    public SQLQuery createQuery(String sql);
}
