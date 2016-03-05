package com.dzeep.dzstage.dao;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by alan on 15/10/7.
 */
public class DaoImp<T> extends HibernateDaoSupport implements IDao<T> {

    @Override
    public T find(Class aClass, int id) {
        return (T) getHibernateTemplate().get(aClass,id);
    }

    @Override
    public void create(T baseBean) {
        getHibernateTemplate().persist(baseBean);
    }

    @Override
    public void save(T baseBean) {
        getHibernateTemplate().save(baseBean);
    }

    @Override
    public void delete(T baseBean) {
        getHibernateTemplate().delete(baseBean);
    }

    @Override
    public List list(String sql) {
        return getHibernateTemplate().find(sql);
    }

    @Override
    public int getTotalCount(String sql, Object... params) {
        Query query = createQuery(sql);
        for (int i=0;params != null && i < params.length; i++){
            query.setParameter(i+1,params[i]);
        }
        Object obj = query.uniqueResult();
        return ((Long)obj).intValue();
    }

    @Override
    public List list(String sql, int firstResult, int maxSize, Object... params) {
        Query query = createQuery(sql);
        for (int i=0;params != null && i < params.length; i++){
            query.setParameter(i+1,params[i]);
        }
        List list = query.setFirstResult(firstResult).setMaxResults(maxSize).list();
        return list;
    }

    @Override
    public SQLQuery createQuery(String sql) {
        return getSessionFactory().getCurrentSession().createSQLQuery(sql);
    }
}
