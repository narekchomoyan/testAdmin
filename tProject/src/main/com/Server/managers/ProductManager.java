package main.com.Server.managers;

import main.com.Server.dataModel.Product.MyTable;
import main.com.Server.dataModel.Product.Order;
import main.com.Server.dataModel.Product.Product;
import main.com.Server.dataModel.Product.ProductInOrder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static ProductManager instance = new ProductManager();

    private ProductManager(){

    }
    public static ProductManager getInstance(){
        return instance;
    }

    public boolean createProduct(Object table){
        boolean s = true;
        Session session = HibernateSessionManager.getInstance().getSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(table);
            t.commit();
        }catch (Exception e){
            t.rollback();
            s= false;
        }
        HibernateSessionManager.getInstance().closeSession(session);
        return s;
    }

    public boolean assignTableToWaiter(long tableId, long waiterId){
        boolean s = true;
        Session session = HibernateSessionManager.getInstance().getSession();
        Transaction t = session.beginTransaction();
        try {
           int reult =  session.createQuery("update MyTable m set " +
                   "m.user.id = :waiterId where m.id = :id")
                   .setParameter("waiterId", waiterId)
                   .setParameter("id",tableId)
                   .executeUpdate();
           if(reult == 0){
               s = false;
           }
           t.commit();
        }catch (Exception e){
            e.printStackTrace();
            t.rollback();
            s = false;
        }
        HibernateSessionManager.getInstance().closeSession(session);
        return s;
    }

    public List<MyTable> getTablesAssignedToUSer(long  userId){
        List<MyTable> tables = new ArrayList<>();
        Session session = HibernateSessionManager.getInstance().getSession();
        List result = session.createQuery("select m from MyTable " +
                "m where m.user.id = :id")
                .setParameter("id", userId)
                .list();
        if(result != null){
            for(Object o : result){
                tables.add((MyTable)o);
            }
        }
        return tables;
    }

    public ProductInOrder getProductInOrderWithId(long id){
        Session session = HibernateSessionManager.getInstance().getSession();
        List result = session.createQuery("select p from ProductInOrder p where p.id = :id")
                .setParameter("id", id)
                .list();
        if(result != null && result.size() > 0){
            return (ProductInOrder) result.get(0);
        }else {
            return null;
        }
    }

    public List<Order> getOpenOrdersForTable(long tableId){
        List<Order> orders = new ArrayList<>();
        Session session = HibernateSessionManager.getInstance().getSession();
        List result = session.createQuery("select  o from Order o where o.status = 3" +
                " and o.tableId = :tableId")
                .setParameter("tableId", tableId)
                .list();
        if(result != null){
            for(Object o: result){
                orders.add((Order)o);
            }
        }
        return orders;
    }

    public boolean addProducts(List<ProductInOrder> objects){
        boolean sucsess = true;
        Session session = HibernateSessionManager.getInstance().getSession();
        Transaction t = session.beginTransaction();
        for(Object o : objects){
            try {
                session.save(o);
            }catch (Exception e){
                t.rollback();
                sucsess = false;
                break;
            }
        }
        if(sucsess){
            t.commit();
        }
        HibernateSessionManager.getInstance().closeSession(session);
        return sucsess;
    }

    public boolean updateProduct(Object p){
        boolean s = true;
        Session session = HibernateSessionManager.getInstance().getSession();
        Transaction t = session.beginTransaction();
        try {
            session.merge(p);
            t.commit();
        }catch (Exception e){
            e.printStackTrace();
            t.rollback();
            s = false;
        }
        return s;
    }

    public Order getOrderWithId(long id){
        Session session = HibernateSessionManager.getInstance().getSession();
        List result = session.createQuery("select o from " +
                "Order o where o.id = :id")
                .setParameter("id", id)
                .list();
        if(result != null && result.size() > 0){
            return (Order) result.get(0);
        }else {
            return null;
        }
    }
}
