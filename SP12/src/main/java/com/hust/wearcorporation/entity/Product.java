package com.hust.wearcorporation.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable{

    @Id
    @Column(name = "product_id", length = 10, nullable = false)
    private String product_id;

    @Column(name = "product_name", length = 50, nullable = false)
    private String product_name;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "category", length = 50, nullable = false)
    private String category;

    @Column(name = "quantity_storage", nullable = false)
    private int quantity_storage;

    @Column(name = "description", length = 100, nullable = false)
    private String description;

    public Product() {

    }

    public Product(String product_id, String product_name, int price, String category, int quantity_storage, String description) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.category = category;
        this.quantity_storage = quantity_storage;
        this.description = description;
    }

    public Product(String product_id, String product_name, int price, String category, String description) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    public String getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity_storage() {
        return this.quantity_storage;
    }

    public void setQuantity_storage(int quantity_storage) {
        this.quantity_storage = quantity_storage;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
