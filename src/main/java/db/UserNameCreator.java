package db;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserNameCreator extends Db {
    private Session session;
    private Transaction transaction;
    public void insertProdus(User user){
        getSessionAndTranzaction();
        session.persist(user);
        // produs.setName("rosie");
        commitTranzactionAndCloseSession();
    }
    public void getSessionAndTranzaction(){
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    public void commitTranzactionAndCloseSession(){
        transaction.commit();
        session.close();
    }
    public void getSessionAndTransaction() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    public User getUserByName(String name){
        getSessionAndTransaction();
        Query query=session.createNamedQuery("find_by_name");
        query.setParameter("user", name);
        User user =(User) query.getSingleResult();
        commitTranzactionAndCloseSession();
        return user;
    }
}
