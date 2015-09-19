package com.dzbackstage.controller;

import com.dzeep.dzframe.controller.DZController;

/**
 * Created by fighting on 15/9/16.
 */
public class BKIndex extends DZController{
    @Override
    public String execute() throws Exception {
//
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure() // configures settings from hibernate.cfg.xml
//                .build();
//        try {
//            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
//            Session session = sessionFactory.openSession();
//            session.beginTransaction(); // 或者 session.getTransaction().begin();
//            UserInfo userInfo_one = new UserInfo();
//            userInfo_one.setUserName("lihua");
//            userInfo_one.setPassword("123456");
//            userInfo_one.setEmail("adfllkj@123.com");
//            userInfo_one.setRegTime(new Date());
//            session.save(userInfo_one);
//
//            UserInfo userInfo_two = new UserInfo();
//            userInfo_two.setUserName("zhangsan");
//            userInfo_two.setPassword("789456");
//            userInfo_two.setEmail("wquoiruo@456.com");
//            userInfo_two.setRegTime(new Date());
//            session.save( userInfo_two );
//
//            session.getTransaction().commit();
//            session.close();
//
//            // now lets pull events from the database and list them
//           /* session = sessionFactory.openSession();
//            session.beginTransaction();
//            List result;
//            result = session.createQuery( "from account" ).list();
//            for ( UserInfoService userInfo : (List<UserInfoService>) result) {
//                System.out.println( "UserInfoService (" + userInfo.getRegTime() + ") : " + userInfo.getUserName() );
//            }
//            session.getTransaction().commit();
//            session.close(); */
//            return SUCCESS;
//        }catch (Exception e) {
//            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
//            // so destroy it manually.
//            StandardServiceRegistryBuilder.destroy( registry );
//        }
        
        return LOGIN;
    }

}
