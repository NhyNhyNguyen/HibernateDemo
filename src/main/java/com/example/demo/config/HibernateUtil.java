package com.example.demo.config;

import com.example.demo.entities.CustomersEntity;
import com.example.demo.entities.OptimisticError;
import com.example.demo.entities.oneToMany.Answer;
import com.example.demo.entities.oneToMany.Question;
import com.example.demo.entities.oneToOne.*;
import com.example.demo.entities.tableHierachy.TPH_Employee;
import com.example.demo.entities.tableHierachy.TPH_Person;
import com.example.demo.entities.tablePerConcret.TPCEmployee;
import com.example.demo.entities.OrdersEntity;
import com.example.demo.entities.tablePerConcret.TPCPerson;
import com.example.demo.entities.tablePerSubClass.TPS_Employee;
import com.example.demo.entities.tablePerSubClass.TPS_Person;
import com.example.demo.enver.ExampleListener;
import com.example.demo.enver.ExampleRevEntity;
import com.example.demo.repositories.AbstractRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

@SuppressWarnings("all")
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
        settings.put("hibernate.listeners.envers.autoRegister", true); //default
        settings.put("hibernate.envers.autoRegisterListeners", true); //default
        configure.setProperties(settings);

        configure.addAnnotatedClass(CustomersEntity.class);
        configure.addAnnotatedClass(OrdersEntity.class);
        configure.addAnnotatedClass(TPCPerson.class);
        configure.addAnnotatedClass(TPCEmployee.class);
        configure.addAnnotatedClass(TPH_Employee.class);
        configure.addAnnotatedClass(TPH_Person.class);
        configure.addAnnotatedClass(TPS_Employee.class);
        configure.addAnnotatedClass(TPS_Person.class);
        configure.addAnnotatedClass(Answer.class);
        configure.addAnnotatedClass(Question.class);
        configure.addAnnotatedClass(TPS_Person.class);
        configure.addAnnotatedClass(Foreign_Customer.class);
        configure.addAnnotatedClass(Foreign_CustomerRecord.class);
        configure.addAnnotatedClass(PrimaryKey_EmployeeInfo.class);
        configure.addAnnotatedClass(PrimaryKey_Employee.class);
        configure.addAnnotatedClass(PrimaryKey_Employee2.class);
        configure.addAnnotatedClass(PrimaryKey_EmployeeInfo2.class);
        configure.addAnnotatedClass(Embedded_Location.class);
        configure.addAnnotatedClass(Embedded_Employee.class);
        configure.addAnnotatedClass(Embedded_ParkingSlot.class);
        configure.addAnnotatedClass(ExampleRevEntity.class);
        configure.addAnnotatedClass(ExampleListener.class);
        configure.addAnnotatedClass(OptimisticError.class);

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
        testOptimisticError(abstractRepository);
    }

    private static void testOptimisticError(AbstractRepository abstractRepository){
        OptimisticError error = new OptimisticError();
        error.setName("Nhi");

        abstractRepository.save(error);

        System.out.println("Object in first save" + error.toString());
        error = (OptimisticError) abstractRepository.findById(OptimisticError.class, error.getId());
        System.out.println("Object in get after first save" + error.toString());
        error.setName("Nhi 2");
        abstractRepository.merge(error);
        System.out.println("Object in get update" + error.toString());
        error = (OptimisticError) abstractRepository.findById(OptimisticError.class, error.getId());
        System.out.println("Object in get after update" + error.toString());
        error.setName("Nhi 3");
        //set different version => throw error
        error.setVersion(error.getVersion() - 1);
        abstractRepository.merge(error);
        System.out.println("Object in get after update version" + error.toString());

    }

    private static void testOneToOneWithForeignKey(AbstractRepository abstractRepository) {
        Foreign_CustomerRecord customerRecord = new Foreign_CustomerRecord();
        Foreign_Customer customer = new Foreign_Customer();
        customer.setCustomerRecord(customerRecord);

        abstractRepository.save(customer);
    }

    /**
     * Create one-to-one relation with primary key
     *
     * @param abstractRepository
     */
    private static void testOneToOneWithPrimaryKey(AbstractRepository abstractRepository) {
        PrimaryKey_Employee employee = new PrimaryKey_Employee();
        PrimaryKey_EmployeeInfo employeeInfo = new PrimaryKey_EmployeeInfo();
        employee.setEmployeeInfo(employeeInfo);

        abstractRepository.save(employee);
    }

    private static void testOneToOneWithPrimaryKey2(AbstractRepository abstractRepository) {
        PrimaryKey_Employee2 employee = new PrimaryKey_Employee2();
        PrimaryKey_EmployeeInfo2 employeeInfo = new PrimaryKey_EmployeeInfo2();
        employee.setEmployeeInfo(employeeInfo);

        employee.setId(1111L);
        employeeInfo.setId(1111L);
        abstractRepository.save(employee);
    }

    private static void testOneToOneWithEmbedded(AbstractRepository abstractRepository) {
        Embedded_Employee employee = new Embedded_Employee();
        Embedded_Location location = new Embedded_Location();
        Embedded_ParkingSlot parkingSlot = new Embedded_ParkingSlot();
        parkingSlot.setGarageId(1L);

        location.setParkingSlot(parkingSlot);
        location.setLocation("Location");
        location.setParkingSlot(parkingSlot);

        employee.setLocation(location);

        //if don't have cascade need to save parkingSlot before, if it have it will auto save
        abstractRepository.save(parkingSlot);
        abstractRepository.save(employee);

        //todo find packing lot
        employee = (Embedded_Employee) abstractRepository.findById(Embedded_Employee.class, employee.getId());
        parkingSlot = (Embedded_ParkingSlot) abstractRepository.findById(Embedded_ParkingSlot.class, parkingSlot.getId());
        System.out.println(parkingSlot);
    }

    public static void testTPC() {
        AbstractRepository abstractRepository = new AbstractRepository();

        TPCPerson TPCPerson = new TPCPerson();
        TPCPerson.setId(2L);
        TPCPerson.setName("tpc person");

        TPCEmployee TPCEmployee = new TPCEmployee();
        TPCEmployee.setId(2L);
        TPCEmployee.setSalary("1111");
        TPCEmployee.setName("tpc employee");

        abstractRepository.save(TPCEmployee);
        abstractRepository.save(TPCPerson);
    }

    public static void testTPH() {
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

    public static void testTPS() {
        AbstractRepository abstractRepository = new AbstractRepository();

        TPS_Person person = new TPS_Person();
        person.setId(7L);
        person.setName("tps person");

        TPS_Employee employee = new TPS_Employee();
        employee.setId(8L);
        employee.setSalary("1111");
        employee.setName("tps employee");

        abstractRepository.save(person);
        abstractRepository.save(employee);
    }

    public static void testOneToMany() {
        AbstractRepository abstractRepository = new AbstractRepository();

        Answer ans1 = new Answer();
        ans1.setAnswerName("Java is a programming language");
        ans1.setPostedBy("Ravi Malik");

        Answer ans2 = new Answer();
        ans2.setAnswerName("Java is a platform");
        ans2.setPostedBy("Sudhir Kumar");

        Answer ans3 = new Answer();
        ans3.setAnswerName("Servlet is an Interface");
        ans3.setPostedBy("Jai Kumar");

        Answer ans4 = new Answer();
        ans4.setAnswerName("Servlet is an API");
        ans4.setPostedBy("Arun");

        ArrayList<Answer> list1 = new ArrayList<Answer>();
        list1.add(ans1);
        list1.add(ans2);

        ArrayList<Answer> list2 = new ArrayList<Answer>();
        list2.add(ans3);
        list2.add(ans4);

        Question question1 = new Question();
        question1.setQuestionName("What is Java?");
        question1.setAnswers(list1);

        Question question2 = new Question();
        question2.setQuestionName("What is Servlet?");
        question2.setAnswers(list2);

        abstractRepository.save(question1);
        abstractRepository.save(question2);

        question1.getAnswers().get(0).setAnswerName("aaaaaaaaaaa");
        abstractRepository.merge(question1.getAnswers().get(0));

    }
}
