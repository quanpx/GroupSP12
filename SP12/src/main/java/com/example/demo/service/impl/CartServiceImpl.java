package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.ProductRepository;
import com.example.demo.dto.ProductInCart;
import com.example.demo.model.Product;
import com.example.demo.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final ProductServiceImpl productService;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository, ProductServiceImpl productService) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @Override
    public void addProductToCart(Product product) {
        cartRepository.addProductToCart(product);
    }

    @Override
    public List<ProductInCart> getCart() {
	    updateCart();
        return cartRepository.getProductInCartList();
	}

    @Override
    public Optional<ProductInCart> getProductInCartById(String product_id){
        return cartRepository.getProductInCartById(product_id);
    }

    @Override
    public int removeProductFromCart(String product_id) {
        return cartRepository.removeProductFromCart(product_id);
    }

    @Override
    public String updateProductQuantityInCart(String product_id, ProductInCart productInCart) {
        if (productService.checkAvailableProduct(product_id, productInCart.getQuantity())) {
            cartRepository.updateProductQuantityInCart(product_id, productInCart);
            return "Update successfully";
        } else return "Update unsuccessfully";
    }

    @Override
    public void makeEmptyCart() {
        cartRepository.makeEmptyCart();
    }

    public boolean checkCart() {
        updateCart();
        boolean check = false;
        for (ProductInCart p : cartRepository.getProductInCartList()) {
            if (p.getStatus() == 0) {
                check = false;
                break;
            } else check = true;
            break;
        }
        return check;
    }

    public void updateCart() {
        for (ProductInCart p : cartRepository.getProductInCartList()) {
            Optional<Product> product = productRepository.findById(p.getProduct_id());
            p.setPrice(product.get().getPrice());
            p.setProduct_name(product.get().getProduct_name());
            if (productService.checkAvailableProduct(p.getProduct_id(), p.getQuantity())) {
                p.setStatus(1);
            } else p.setStatus(0);
        }
    }
}
