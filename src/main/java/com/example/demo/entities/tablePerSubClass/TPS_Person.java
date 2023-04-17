package com.example.demo.entities.tablePerSubClass;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TPS_PERSON", schema = "DEMO", catalog = "")
@Inheritance(strategy = InheritanceType.JOINED)
public class TPS_Person {
    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    private long id;

    private String name;

    @Transient
    private List<String> data;

    public TPS_Person() {
    }

    public TPS_Person(long id, String name, List<String> data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
