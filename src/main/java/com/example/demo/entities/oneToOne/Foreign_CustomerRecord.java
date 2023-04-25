package com.example.demo.entities.oneToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
public class Foreign_CustomerRecord {
    @Getter
    @Setter
    @Id
    @Column(name = "CUSREC_ID")
    private Long id;
}
