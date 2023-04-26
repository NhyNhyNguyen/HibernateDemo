package com.example.demo.entities.oneToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PrimaryKey_Employee {
    @Column
    @Id
    private Long id;

    @OneToOne
    @MapsId
    private PrimaryKey_EmployeeInfo employeeInfo;
}
