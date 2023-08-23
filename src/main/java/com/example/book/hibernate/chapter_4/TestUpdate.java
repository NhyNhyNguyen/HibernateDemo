package com.example.book.hibernate.chapter_4;

import com.example.book.hibernate.config.HibernateUtil;
import com.example.book.hibernate.entities.Test;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class TestUpdate {
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

        user.setPassword("xxxxx");
        Session session2 = HibernateUtil.sessionFactory.openSession();
        Transaction tx2 = session2.beginTransaction();
        session2.lock(user, LockMode.NONE); //result xxxx nhi2
        //session2.update(user); // result xxxx nhi2
        //session2.merge(user); //result xxxx nhi
        user.setUsername("Nhi 2");
        tx2.commit();
        session2.close();
    }
}
