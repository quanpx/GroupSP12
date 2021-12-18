package com.hust.wearcorporation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ProductInCart {
    @JsonProperty("product_id")
    private String product_id;

    @JsonProperty("product_name")
    private String product_name;

    @JsonProperty("price")
    private int price;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("status")
    private int status;  

    public ProductInCart() {
        
    }

    public ProductInCart(String product_id, String product_name, int price, int quantity, int status) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
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

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }     
}