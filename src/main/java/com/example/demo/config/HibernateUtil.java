package com.example.demo.config;

import com.example.demo.entities.CustomersEntity;
import com.example.demo.entities.OrdersEntity;
import com.example.demo.entities.Test;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.TestRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class HibernateUtil {
    /**
     * Connect throught java code
     *
     * @return
     */
    public static EntityManager getEntityManager() {

        Configuration configure = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "oracle.jdbc.OracleDriver");
        settings.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:XE");
        settings.put(Environment.USER, "DEMO");
        settings.put(Environment.PASS, "123$%^");
        settings.put(Environment.HBM2DDL_AUTO, "update");

        configure.setProperties(settings);

        configure.addAnnotatedClass(CustomersEntity.class);
        configure.addAnnotatedClass(OrdersEntity.class);
        configure.addAnnotatedClass(Test.class);
        SessionFactory entityManagerFactory;
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build();

        entityManagerFactory = configure.buildSessionFactory(serviceRegistry);

        return entityManagerFactory.createEntityManager();
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
        CustomerRepository customerRepository = new CustomerRepository();

        CustomersEntity entity = new CustomersEntity();
        entity.setName("icon");

        customerRepository.save(entity);

        TestRepository testRepository = new TestRepository();
        Test test = new Test();

        test.setId(22);
        test.setName("1111");

        testRepository.save(test);
        System.out.println(entity);
    }
}
