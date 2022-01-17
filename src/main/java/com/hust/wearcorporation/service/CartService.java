package com.hust.wearcorporation.service;

import java.util.List;
import java.util.Optional;

import com.hust.wearcorporation.dto.CartProductDto;
import com.hust.wearcorporation.entity.Product;

public interface CartService {
    public void addProductToCart(Product product);
    public List<CartProductDto> getCart();
    public Optional<CartProductDto> getProductInCartById(String product_id);
    public int removeProductFromCart(String product_id);
    public String updateProductQuantityInCart(String product_id, CartProductDto productInCart);
    public void makeEmptyCart();
}
