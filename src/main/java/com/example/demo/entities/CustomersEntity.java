package com.example.demo.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMERS", schema = "DEMO", catalog = "")
public class CustomersEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ")
    @SequenceGenerator(name = "CUSTOMER_SEQ", sequenceName = "CUSTOMER_SEQ", allocationSize = 1, initialValue = 1)
    private long id;
    @Basic
    @Column(name = "ADDRESS", nullable = true, length = 255)
    private String address;
    @Basic
    @Column(name = "BIRTHDAY", nullable = true)
    private Date birthday;
    @Basic
    @Column(name = "CUSTOMER_TYPE", nullable = true, precision = 0)
    private Integer customerType;
    @Basic
    @Column(name = "DOCUMENTS", nullable = true, length = 255)
    private String documents;
    @Basic
    @Column(name = "EMAIL", nullable = true, length = 255)
    private String email;
    @Basic
    @Column(name = "FILE_NAME", nullable = true, length = 255)
    private String fileName;
    @Basic
    @Column(name = "GENDER", nullable = true, precision = 0)
    private Boolean gender;
    @Basic
    @Column(name = "NAME", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "PHONE", nullable = true, length = 255)
    private String phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomersEntity that = (CustomersEntity) o;
        return id == that.id && Objects.equals(address, that.address) && Objects.equals(birthday, that.birthday) && Objects.equals(customerType, that.customerType) && Objects.equals(documents, that.documents) && Objects.equals(email, that.email) && Objects.equals(fileName, that.fileName) && Objects.equals(gender, that.gender) && Objects.equals(name, that.name) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, birthday, customerType, documents, email, fileName, gender, name, phone);
    }

    @Override
    public String toString() {
        return "CustomersEntity{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", customerType=" + customerType +
                ", documents='" + documents + '\'' +
                ", email='" + email + '\'' +
                ", fileName='" + fileName + '\'' +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
