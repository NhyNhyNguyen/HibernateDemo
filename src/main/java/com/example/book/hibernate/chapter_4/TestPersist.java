package com.example.book.hibernate.chapter_4;

import com.example.book.hibernate.config.HibernateUtil;
import com.example.book.hibernate.entities.Test;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class TestPersist {
    static  {
        HibernateUtil.getEntityManager();
    }
    public static void main(String[] args) {
        Session session = HibernateUtil.sessionFactory.openSession();

        Test user = new Test();
        user.setUsername("Nhi");

        Transaction tx = session.beginTransaction();

        session.save(user);
        tx.commit();
        session.close();
    }
}
