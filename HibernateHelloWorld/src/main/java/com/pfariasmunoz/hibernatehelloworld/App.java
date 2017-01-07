package com.pfariasmunoz.hibernatehelloworld;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author pablo
 */
public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory;
        sessionFactory = new Configuration()
                .configure() // configures settings from hibernate.cfg.xml
                .buildSessionFactory();
 
        Session session = sessionFactory.openSession();
 
        Transaction tx = session.beginTransaction();
        Task task = new Task();
        task.setId(new Long(1));
        task.setName("Hello world task");
        task.setDescription("Hello world task description");
        session.save(task);
        tx.commit();
        session.close();
        
    }
}
