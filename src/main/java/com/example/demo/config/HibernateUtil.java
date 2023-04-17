package com.example.demo.config;

import com.example.demo.entities.CustomersEntity;
import com.example.demo.entities.tableHierachy.TPH_Employee;
import com.example.demo.entities.tableHierachy.TPH_Person;
import com.example.demo.entities.tablePerConcret.Employee;
import com.example.demo.entities.OrdersEntity;
import com.example.demo.entities.tablePerConcret.Person;
import com.example.demo.entities.tablePerSubClass.TPS_Employee;
import com.example.demo.entities.tablePerSubClass.TPS_Person;
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
        configure.addAnnotatedClass(TPH_Employee.class);
        configure.addAnnotatedClass(TPH_Person.class);
        configure.addAnnotatedClass(TPS_Employee.class);
        configure.addAnnotatedClass(TPS_Person.class);
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
        testTPS();
    }

    public static void testTPC(){
        AbstractRepository abstractRepository = new AbstractRepository();

        Person person = new Person();
        person.setId(2L);
        person.setName("tpc person");

        Employee employee = new Employee();
        employee.setId(2L);
        employee.setSalary("1111");
        employee.setName("tpc employee");

        abstractRepository.save(employee);
        abstractRepository.save(person);
    }

    public static void testTPH(){
        AbstractRepository abstractRepository = new AbstractRepository();

        TPH_Person person = new TPH_Person();
        person.setId(2L);
        person.setName("tpc person");

        TPH_Employee employee = new TPH_Employee();
        employee.setId(3L);
        employee.setSalary("1111");
        employee.setName("tpc employee");

        abstractRepository.save(person);
        abstractRepository.save(employee);
    }

    public static void testTPS(){
        AbstractRepository abstractRepository = new AbstractRepository();

        TPS_Person person = new TPS_Person();
        person.setId(20L);
        person.setName("tpc person");

        TPS_Employee employee = new TPS_Employee();
        employee.setId(20L);
        employee.setSalary("1111");
        employee.setName("tpc employee");

        abstractRepository.save(employee);
        abstractRepository.save(person);
    }
}
