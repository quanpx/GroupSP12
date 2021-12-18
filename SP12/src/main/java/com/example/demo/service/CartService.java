package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.ProductInCart;
import com.example.demo.model.Product;

public interface CartService {
    public void addProductToCart(Product product);
    public List<ProductInCart> getCart();
    public Optional<ProductInCart> getProductInCartById(String product_id);
    public int removeProductFromCart(String product_id);
    public String updateProductQuantityInCart(String product_id, ProductInCart productInCart);
    public void makeEmptyCart();
}
