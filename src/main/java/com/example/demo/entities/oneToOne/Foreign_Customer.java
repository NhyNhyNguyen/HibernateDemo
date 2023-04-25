package com.example.demo.entities.oneToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Foreign_Customer {
    @Setter
    @Getter
    @Id
    private Long id;

    @Setter
    @Getter
    @OneToOne(optional = false)
    @JoinColumn(name = "CUSREC_ID", unique = true, nullable = false, updatable = false)
    private Foreign_CustomerRecord customerRecord;

}
