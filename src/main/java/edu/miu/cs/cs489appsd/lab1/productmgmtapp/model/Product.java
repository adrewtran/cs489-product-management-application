package edu.miu.cs.cs489appsd.lab1.productmgmtapp.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class Product {
    private BigInteger productId;
    private String name;
    private LocalDate dateSupplied;
    private int quantityInStock;
    private BigDecimal unitPrice;

    // Default constructor
    public Product() {}

    // Constructor with all fields
    public Product(BigInteger productId, String name, LocalDate dateSupplied, int quantityInStock, BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    // Constructor with productId, name, unitPrice
    public Product(BigInteger productId, String name, BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
