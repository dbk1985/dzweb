package com.dzbackstage.controller;

import com.dzbackstage.model.UserInfo;
import com.dzeep.dzframe.controller.DZController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;
import java.util.List;

/**
 * Created by fighting on 15/9/16.
 */
public class BKIndex extends DZController{

    private static SessionFactory sessionFactory = null;

    @Override
    public String execute() throws Exception {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction(); // 或者 session.getTransaction().begin();
            session.save( new UserInfo( "Our very first event!", new Date(1111)) );
            session.save( new UserInfo( "A follow up event", new Date(88888)) );
            session.getTransaction().commit();
            session.close();

            // now lets pull events from the database and list them
           /* session = sessionFactory.openSession();
            session.beginTransaction();
            List result;
            result = session.createQuery( "from account" ).list();
            for ( UserInfo userInfo : (List<UserInfo>) result) {
                System.out.println( "UserInfo (" + userInfo.getRegTime() + ") : " + userInfo.getUserName() );
            }
            session.getTransaction().commit();
            session.close(); */
            return SUCCESS;
        }catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }

        return LOGIN;
    }

}
