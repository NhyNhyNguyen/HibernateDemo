package com.example.demo.config;

import com.example.demo.entities.CustomersEntity;
import com.example.demo.entities.Employee;
import com.example.demo.entities.OrdersEntity;
import com.example.demo.entities.Person;
import com.example.demo.repositories.AbstractRepository;
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
        configure.addAnnotatedClass(Person.class);
        configure.addAnnotatedClass(Employee.class);
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
        AbstractRepository abstractRepository = new AbstractRepository();

        Person person = new Person();
        person.setId(1L);
        person.setName("person");

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setSalary("1111");
        employee.setName("employee");

        abstractRepository.save(person);
        abstractRepository.save(employee);
    }
}
