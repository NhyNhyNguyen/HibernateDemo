package com.example.demo.entities.oneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class PrimaryKey_EmployeeInfo2 {
    @Getter
    @Setter
    @Id
    private Long id;
}
