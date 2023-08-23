package com.example.book.hibernate.chapter_4;

import com.example.book.hibernate.config.HibernateUtil;
import com.example.book.hibernate.entities.Test;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class TestDelete {
    static {
        HibernateUtil.getEntityManager();
    }

    public static void main(String[] args) {

        Test user = new Test();
        user.setId(16L);
        Session session1 = HibernateUtil.sessionFactory.openSession();
        Transaction tx2 = session1.beginTransaction();
        session1.delete(user);
        user.setUsername("Nhi nhi");
        tx2.commit();
        session1.close();
    }
}
