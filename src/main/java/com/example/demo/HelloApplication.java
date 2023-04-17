package com.example.demo;

import com.example.demo.entities.CustomersEntity;
import com.example.demo.repositories.CustomerRepository;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class HelloApplication extends Application {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();

        CustomersEntity entity = customerRepository.findById(CustomersEntity.class, 24L);
        System.out.println(entity);
    }
}