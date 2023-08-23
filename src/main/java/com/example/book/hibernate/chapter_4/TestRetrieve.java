package com.example.book.hibernate.chapter_4;

import com.example.book.hibernate.config.HibernateUtil;
import com.example.book.hibernate.entities.Test;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class TestRetrieve {
    static  {
        HibernateUtil.getEntityManager();
    }
    public static void main(String[] args) {
        Session session = HibernateUtil.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Test user = session.get(Test.class, 12L);
        System.out.println(user);

        user.setUsername("Test");
        tx.commit(); //username will change from nhi2 to test
        session.close();
    }
}
