package com.hust.wearcorporation.dao;

import java.util.List;
import java.util.Optional;

import com.hust.wearcorporation.dto.CartProductDto;
import com.hust.wearcorporation.entity.Product;

public interface CartRepository {
    public List<CartProductDto> getProductInCartList();
    public void addProductToCart(Product product);
    public Optional<CartProductDto> getProductInCartById(String product_id);
    public int removeProductFromCart(String product_id);
    public int updateProductQuantityInCart(String product_id, CartProductDto productInCart);
    public void makeEmptyCart();
}
