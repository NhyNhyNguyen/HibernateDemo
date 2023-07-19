package com.example.book.hibernate.config;

import com.example.book.hibernate.entities.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

@SuppressWarnings("all")
public class HibernateUtil {
    public static SessionFactory sessionFactory;

    /**
     * Connect throught java code
     *
     * @return
     */
    public static EntityManager getEntityManager() {
        if (sessionFactory == null) {
            Configuration configure = new Configuration();
            configure.setProperties(System.getProperties());
            //different with addClass() and addAnnotatedClass()
            configure.addAnnotatedClass(Message.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build();

            sessionFactory = configure.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory.createEntityManager();
    }

    /**
     * Connect by file persistence.xml
     *
     * @return
     */
    public static EntityManager getEntityManager2() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        return entityManagerFactory.createEntityManager();
    }

    public static void main(String[] args) {
        getEntityManager();
        testHelloWorld();
    }

    private static void testHelloWorld(){
        Session session = sessionFactory.openSession();
        Message message = new Message("Hello world");
        Message nextMessage = new Message("Next message");
        message.setNextMessage(nextMessage);
        Transaction tx = session.beginTransaction();

        session.save(message);
        session.getTransaction().commit();

        Query query = session.createQuery("from Message as m order by m.id asc");
        List messages = query.list();
        System.out.println(messages);
        session.close();
    }
}
