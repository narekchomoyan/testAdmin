package main.com.Server.managers;

import main.com.Server.dataModel.User.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserManager {
    private static UserManager instance = new UserManager();
    private UserManager(){

    }

    public static UserManager getInstance() {
        return instance;
    }

    public User authenticateUser(String username, String password){
        Session session = HibernateSessionManager.getInstance().getSession();
        List reult = session.createQuery("select u from User  u " +
                "where u.userName = :username and u.password = :password")
                .setParameter("username", username)
                .setParameter("password", password)
                .list();
        if(reult.size() > 0){
            return (User) reult.get(0);
        }else {
            return null;
        }
    }

    public boolean addUser(User user){
        Session session = HibernateSessionManager.getInstance().getSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(user);
            t.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            t.rollback();
            return false;
        }
    }
}
