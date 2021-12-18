package com.hust.wearcorporation.service;

import java.util.List;
import java.util.Optional;

import com.hust.wearcorporation.dto.ProductInCart;
import com.hust.wearcorporation.model.Product;

public interface CartService {
    public void addProductToCart(Product product);
    public List<ProductInCart> getCart();
    public Optional<ProductInCart> getProductInCartById(String product_id);
    public int removeProductFromCart(String product_id);
    public String updateProductQuantityInCart(String product_id, ProductInCart productInCart);
    public void makeEmptyCart();
}
