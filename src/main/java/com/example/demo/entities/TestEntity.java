package com.example.demo.entities;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "TEST", schema = "DEMO", catalog = "")
public class TestEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    private BigInteger id;
    @Basic
    @Column(name = "NAME", nullable = true, length = 100)
    private String name;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestEntity that = (TestEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
