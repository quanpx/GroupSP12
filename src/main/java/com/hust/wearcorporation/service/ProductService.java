package com.hust.wearcorporation.service;

import java.util.List;

import com.hust.wearcorporation.entity.Product;

public interface ProductService {
    public List<Product> getProducts();
    public boolean checkAvailableProduct(String product_id, int value);
}
