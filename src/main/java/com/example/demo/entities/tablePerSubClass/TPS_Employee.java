package com.example.demo.entities.tablePerSubClass;

import com.example.demo.entities.tablePerConcret.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "TPS_EMPLOYEE", schema = "DEMO", catalog = "")
@PrimaryKeyJoinColumn(name="ID")
public class TPS_Employee extends TPS_Person {
    private String salary;

    public TPS_Employee(long id, String name, List<String> data, String salary) {
        super(id, name, data);
        this.salary = salary;
    }

    public TPS_Employee() {

    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
