package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ORDERS", schema = "DEMO", catalog = "")
public class OrdersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    private long id;
    @Basic
    @Column(name = "BATTERY", nullable = true, length = 255)
    private String battery;
    @Basic
    @Column(name = "CABLE_LENGTH", nullable = true, precision = 0)
    private Integer cableLength;
    @Basic
    @Column(name = "CLECK_COMMENT", nullable = true, length = 255)
    private String cleckComment;
    @Basic
    @Column(name = "CONNECTED_POWER", nullable = true, precision = 0)
    private Integer connectedPower;
    @Basic
    @Column(name = "DISCOUNT", nullable = true, precision = 0)
    private Double discount;
    @Basic
    @Column(name = "MANAGE_COMMENT", nullable = true, length = 255)
    private String manageComment;
    @Basic
    @Column(name = "PRODUCT_TYPE", nullable = false, length = 255)
    private String productType;
    @Basic
    @Column(name = "REQUIRE_METER", nullable = true, precision = 0)
    private Boolean requireMeter;
    @Basic
    @Column(name = "STATUS", nullable = true, precision = 0)
    private Integer status;
    @Basic
    @Column(name = "TOTAL", nullable = true, precision = 0)
    private Double total;
    @Basic
    @Column(name = "CUSTOMERID", nullable = true, precision = 0)
    private Long customerid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public Integer getCableLength() {
        return cableLength;
    }

    public void setCableLength(Integer cableLength) {
        this.cableLength = cableLength;
    }

    public String getCleckComment() {
        return cleckComment;
    }

    public void setCleckComment(String cleckComment) {
        this.cleckComment = cleckComment;
    }

    public Integer getConnectedPower() {
        return connectedPower;
    }

    public void setConnectedPower(Integer connectedPower) {
        this.connectedPower = connectedPower;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getManageComment() {
        return manageComment;
    }

    public void setManageComment(String manageComment) {
        this.manageComment = manageComment;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Boolean getRequireMeter() {
        return requireMeter;
    }

    public void setRequireMeter(Boolean requireMeter) {
        this.requireMeter = requireMeter;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return id == that.id && Objects.equals(battery, that.battery) && Objects.equals(cableLength, that.cableLength) && Objects.equals(cleckComment, that.cleckComment) && Objects.equals(connectedPower, that.connectedPower) && Objects.equals(discount, that.discount) && Objects.equals(manageComment, that.manageComment) && Objects.equals(productType, that.productType) && Objects.equals(requireMeter, that.requireMeter) && Objects.equals(status, that.status) && Objects.equals(total, that.total) && Objects.equals(customerid, that.customerid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, battery, cableLength, cleckComment, connectedPower, discount, manageComment, productType, requireMeter, status, total, customerid);
    }
}
