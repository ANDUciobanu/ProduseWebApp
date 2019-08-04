package db;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserNameCreator extends Db {
    private Session session;
    private Transaction transaction;
    public void insertProdus(User user){
        getSessionAndTranzaction();
        session.persist(user);
        // produs.setName("rosie");
        comitTranzactionAndCloseSession();
    }
    public void getSessionAndTranzaction(){
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    public void comitTranzactionAndCloseSession(){
        transaction.commit();
        session.close();
    }
}
