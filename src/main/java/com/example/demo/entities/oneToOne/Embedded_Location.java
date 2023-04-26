package com.example.demo.entities.oneToOne;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Embedded_Location {

    private String location;

    @OneToOne(orphanRemoval = true)
    private Embedded_ParkingSlot parkingSlot;
}
