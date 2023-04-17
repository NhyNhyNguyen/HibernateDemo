package com.example.demo.entities.tableHierachy;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
@DiscriminatorValue("TPH_employee")
public class TPH_Employee extends TPH_Person {
    private String salary;

    public TPH_Employee(long id, String name, List<String> data, String salary) {
        super(id, name, data);
        this.salary = salary;
    }

    public TPH_Employee() {

    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
