package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.Cart;
import com.example.demo.dao.ProductRepository;
import com.example.demo.model.Product;
import com.example.demo.model.ProductInCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final Cart cart;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(Cart cart, ProductRepository productRepository) {
        this.cart = cart;
        this.productRepository = productRepository;
    }

    public void addProductToCart(Product product) {
        cart.addProductToCart(product);
    }

    public List<ProductInCart> getCart() {
		return cart.getProductInCartList();
	}

    public Optional<ProductInCart> getProductInCartById(String product_id){
        return cart.getProductInCartById(product_id);
    }

    public int removeProductFromCart(String product_id) {
        return cart.removeProductFromCart(product_id);
    }

    public void updateProductQuantityInCart(String product_id, ProductInCart productInCart) {
        cart.updateProductQuantityInCart(product_id, productInCart);
    }

    public boolean checkAvailableProduct(String product_id, int value) {
        Optional<Product> product = productRepository.findById(product_id);
        if (product.get().getQuantity_storage()>=value) {
            return true;
        } else return false;
    }
}
