package com.example.demo.entities.oneToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class PrimaryKey_Employee {

    @Getter
    @Setter
    @Column
    @Id
    private Long id;

    @Getter
    @Setter
    @OneToOne
    @MapsId
    private PrimaryKey_EmployeeInfo employeeInfo;
}
