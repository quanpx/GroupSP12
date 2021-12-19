package com.hust.wearcorporation.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hust.wearcorporation.dao.CartRepository;
import com.hust.wearcorporation.dto.ProductInCart;
import com.hust.wearcorporation.model.Product;

import org.springframework.stereotype.Repository;

@Repository
public class CartRepositoryImpl implements CartRepository {
    private List<ProductInCart> productInCartList = new ArrayList<>();

    @Override
    public List<ProductInCart> getProductInCartList() {
        return this.productInCartList;
    }

    @Override
    public void addProductToCart(Product product) {
        Optional<ProductInCart> productInCart = getProductInCartById(product.getProduct_id());
        if (productInCart.isEmpty()) {
            ProductInCart newProduct = new ProductInCart(product.getProduct_id(), product.getProduct_name(), product.getPrice(), 1, 1);
            productInCartList.add(newProduct);
        } else {
            productInCart.get().setQuantity(productInCart.get().getQuantity() + 1);
        }
    }

    @Override
    public Optional<ProductInCart> getProductInCartById(String product_id) {
        return productInCartList.stream()
                .filter(productInCart -> productInCart.getProduct_id().equals(product_id))
                .findFirst();
    }

    @Override
    public int removeProductFromCart(String product_id) {
        Optional<ProductInCart> productInCart = getProductInCartById(product_id);
        if (productInCart.isEmpty()) {
            return 0;
        }
        productInCartList.remove(productInCart.get());
        return 1;
    }

    @Override
    public int updateProductQuantityInCart(String product_id, ProductInCart productInCart) {
        Optional<ProductInCart> tempProduct = getProductInCartById(product_id);
        return tempProduct
                .map(product -> {
                    int indexOfProductInCartToUpdate = productInCartList.indexOf(product);
                    if (indexOfProductInCartToUpdate >= 0) {
                        productInCartList.set(indexOfProductInCartToUpdate, new ProductInCart(product_id, tempProduct.get().getProduct_name(), tempProduct.get().getPrice(), productInCart.getQuantity(), 1));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public void makeEmptyCart() {
        productInCartList.clear();
    }
}
