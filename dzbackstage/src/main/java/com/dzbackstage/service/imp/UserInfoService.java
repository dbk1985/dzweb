package com.dzbackstage.service.imp;

import com.dzbackstage.dao.imp.UserInfoDao;
import com.dzbackstage.model.UserInfo;
import com.dzbackstage.service.BKService;

import java.util.List;

/**
 * Created by tb on 15/9/17.
 */
public class UserInfoService extends BKService{
    private UserInfoDao userInfoDao;

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }
    @Override
    public List<UserInfoService> findAll() {
        return null;
    }

    @Override
    public void save(Object o) {
        userInfoDao.save(o);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public UserInfo find(int id) {
        return null;
    }

    public UserInfo findByUseName(String uName){
        return userInfoDao.findByUserName(uName);
    }
}
