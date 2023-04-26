package com.example.demo.entities.oneToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Embedded_ParkingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long garageId;

    @OneToOne(mappedBy = "location.parkingSlot")
    private Embedded_Employee employee;
}
