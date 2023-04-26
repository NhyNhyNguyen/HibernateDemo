package com.example.demo.entities.oneToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
public class Foreign_CustomerRecord {
    @Getter
    @Setter
    @Id
    @Column(name = "CUSREC_ID")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
}
