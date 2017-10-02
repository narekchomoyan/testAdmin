package main.com.Server.managers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.context.ApplicationContext;

/**
 * Created by Narek on 7/5/2017.
 */
public class HibernateSessionManager {
    private SessionFactory sessionFactory;
    private static HibernateSessionManager instance = new HibernateSessionManager();
    private HibernateSessionManager(){

    }

    public static HibernateSessionManager getInstance(){
        return instance;
    }

    public void init(ApplicationContext applicationContext){
        sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
    }

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public Session getSession() {
        if(sessionFactory != null){
            return sessionFactory.openSession();
        }
        return null;
    }

    public void closeSession(Session session){
        Transaction tx = session.getTransaction();
        if(tx.getStatus().equals(TransactionStatus.ACTIVE) ){
            tx.commit();
        }
        session.close();
    }
}
