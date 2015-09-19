package com.dzbackstage.service;

import java.util.List;

/**
 * Created by tb on 15/9/17.
 * 业务处理层
 */
public abstract class BKService<T> {
    /*
    private static SessionFactory sessionFactory = null;
    private static EntityManagerFactory entityManagerFactory = null;
    */
    abstract public List<T> findAll();

    abstract public void save(T t);

    abstract public void remove(int id);

    abstract public T find(int id);

    /** ORM模式 */
   /* protected static Session openSession() {
        if (sessionFactory == null) {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            try {
                sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            }catch (Exception e){
                StandardServiceRegistryBuilder.destroy(registry);
            }
        }
        return sessionFactory.openSession();
    }

    public void executeActionWithSession(Object o,String s){
        Session session = openSession();
        session.getTransaction().begin();
        if (s == null){
            session.persist(o);
        }else{
            session.persist(s,o);
        }
        session.getTransaction().commit();
        session.close();
    }

    protected static Session openSessionWithConfig(){
        return null;
    }
    */
    /** JPA模式 */
    /*
    protected static EntityManager openEntityManager(String persistenceUnitName) {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        }
        return entityManagerFactory.createEntityManager();
    }

    public void executeActionWithEntityManager(String persistenceUnitName,Object o){
        EntityManager entityManager = openEntityManager(persistenceUnitName);
        entityManager.getTransaction().begin();
        entityManager.persist( o );
        entityManager.getTransaction().commit();
    }
    */
}
