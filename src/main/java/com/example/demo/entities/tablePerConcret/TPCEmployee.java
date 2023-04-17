package com.example.demo.entities.tablePerConcret;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "EMPLOYEE", schema = "DEMO", catalog = "")
@AttributeOverrides({
        @AttributeOverride(name="id", column=@Column(name="id")),
        @AttributeOverride(name="name", column=@Column(name="name"))
})
public class TPCEmployee extends TPCPerson {
    private String salary;

    public TPCEmployee(long id, String name, List<String> data, String salary) {
        super(id, name, data);
        this.salary = salary;
    }

    public TPCEmployee() {

    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
