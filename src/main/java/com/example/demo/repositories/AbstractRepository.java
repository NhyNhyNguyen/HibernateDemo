package com.example.demo.repositories;

import com.example.demo.config.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class AbstractRepository<T, ID> {

    public T findById(Class clazz, ID id) {
        return (T) HibernateUtil.getEntityManager().find(clazz, id);
    }

    public T save(T t) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        return t;
    }

    public T merge(T t) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityManager entityManager2 = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager2.getTransaction().begin();
        entityManager2.merge(t);
        entityManager2.getTransaction().commit();
        entityManager.getTransaction().commit();
        return t;
    }
}
