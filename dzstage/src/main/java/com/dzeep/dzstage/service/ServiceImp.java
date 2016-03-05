package com.dzeep.dzstage.service;

import com.dzeep.dzstage.dao.IDao;
import com.dzeep.dzstage.model.BaseBean;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by alan on 15/10/7.
 */
public abstract class ServiceImp<T extends BaseBean> implements IService<T>{

    protected IDao<T> dao;

    public IDao<T> getDao() {
        return dao;
    }

    public void setDao(IDao<T> dao) {
        this.dao = dao;
    }

    @Override
    public T find(Class<T> tClass, int id) {
        return dao.find(tClass,id);
    }

    @Override
    public abstract void create(T baseBean);

    @Override
    public  void save(T baseBean){
        dao.save(baseBean);
    }

    @Override
    public void delete(T baseBean) {
        baseBean.setDeleted(true);
        dao.delete(baseBean);
    }

    @Override
    public List<T> list(String sql) {
        return dao.list(sql);
    }

    @Override
    public int getTotalCount(String sql, Object... params) {
        return dao.getTotalCount(sql,params);
    }

    @Override
    public List<T> list(String sql, int firstResult, int maxSize, Object... params) {
        return dao.list(sql,firstResult,maxSize,params);
    }
}
