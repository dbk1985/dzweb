package com.dzbackstage.service.imp;

import com.dzbackstage.dao.imp.SiteDao;
import com.dzbackstage.service.BKService;

import java.util.List;

/**
 * Created by fighting on 15/9/19.
 */
public class SiteService extends BKService{
    SiteDao siteDao;

    public void setSiteDao(SiteDao siteDao) {
        this.siteDao = siteDao;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Object find(int id) {
        return null;
    }
}
