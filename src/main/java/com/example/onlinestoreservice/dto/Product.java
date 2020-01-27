package com.example.onlinestoreservice.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Product  extends EntityBase{

    private String code;
    private String name;
    private String brand;
    private String description;
    @Column(name = "unit_price")
    private float unitPrice;
    private int quantity;
    @Column(name="category_id")
    private int categoryId;
    @Column(name="supplier_id")
    private int supplierId;
    private int purchases;
    private int views;

    public Product(){
        this.code = "PRD"+ UUID.randomUUID().toString().substring(26).toUpperCase();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
