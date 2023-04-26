package com.example.demo.entities.oneToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class PrimaryKey_EmployeeInfo {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
}
