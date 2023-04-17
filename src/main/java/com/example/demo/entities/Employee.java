package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "EMPLOYEE", schema = "DEMO", catalog = "")
@AttributeOverrides({
        @AttributeOverride(name="id", column=@Column(name="id")),
        @AttributeOverride(name="name", column=@Column(name="name"))
})
public class Employee extends Person{
    private String salary;

    public Employee(long id, String name, List<String> data, String salary) {
        super(id, name, data);
        this.salary = salary;
    }

    public Employee() {

    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
