package com.example.demo.entities.oneToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class PrimaryKey_Employee2 {

    @Getter
    @Setter
    @Column
    @Id
    private Long id;

    @Getter
    @Setter
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", unique = true, nullable = false, updatable = false)
    private PrimaryKey_EmployeeInfo2 employeeInfo;
}
