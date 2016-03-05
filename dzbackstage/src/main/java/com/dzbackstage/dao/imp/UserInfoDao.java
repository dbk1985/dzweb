package com.dzbackstage.dao.imp;

import com.dzbackstage.dao.BKDao;
import com.dzbackstage.model.UserInfo;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by tb on 15/9/18.
 * 用户信息 在spring配置中使用mapping resources类映射文件
 */
public class UserInfoDao extends BKDao{

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public void save(Object o) {
        currentSession().save(o);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public UserInfo find(int id) {
        return null;
    }

    public UserInfo findByUserName(String uName){
        Session session = currentSession();
        Query query = session.createSQLQuery("SELECT * FROM account WHERE account = :name")
                .addEntity(UserInfo.class) /** 必需添加否则会出现类型转化异常(Ljava.lang.Object; cannot be cast to xxx)*/
                .setString("name", uName);
        UserInfo userInfo = (UserInfo)query.uniqueResult();
        session.close();
        return userInfo;
    }
}
