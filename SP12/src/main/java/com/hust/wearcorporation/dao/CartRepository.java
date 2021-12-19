package com.hust.wearcorporation.dao;

import java.util.List;
import java.util.Optional;

import com.hust.wearcorporation.dto.ProductInCart;
import com.hust.wearcorporation.model.Product;

public interface CartRepository {
    public List<ProductInCart> getProductInCartList();
    public void addProductToCart(Product product);
    public Optional<ProductInCart> getProductInCartById(String product_id);
    public int removeProductFromCart(String product_id);
    public int updateProductQuantityInCart(String product_id, ProductInCart productInCart);
    public void makeEmptyCart();
}
