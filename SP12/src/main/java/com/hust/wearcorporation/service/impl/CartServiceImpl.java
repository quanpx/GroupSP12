package com.hust.wearcorporation.service.impl;

import java.util.List;
import java.util.Optional;

import com.hust.wearcorporation.dao.ProductRepository;
import com.hust.wearcorporation.dao.impl.CartRepositoryImpl;
import com.hust.wearcorporation.dto.CartProductDto;
import com.hust.wearcorporation.entity.Product;
import com.hust.wearcorporation.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
    private final CartRepositoryImpl cartRepository;
    private final ProductRepository productRepository;
    private final ProductServiceImpl productService;

    @Autowired
    public CartServiceImpl(CartRepositoryImpl cartRepository, ProductRepository productRepository, ProductServiceImpl productService) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @Override
    public void addProductToCart(Product product) {
        cartRepository.addProductToCart(product);
    }

    @Override
    public List<CartProductDto> getCart() {
	    updateCart();
        return cartRepository.getProductInCartList();
	}

    @Override
    public Optional<CartProductDto> getProductInCartById(String product_id){
        return cartRepository.getProductInCartById(product_id);
    }

    @Override
    public int removeProductFromCart(String product_id) {
        return cartRepository.removeProductFromCart(product_id);
    }

    @Override
    public String updateProductQuantityInCart(String product_id, CartProductDto productInCart) {
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
        for (CartProductDto p : cartRepository.getProductInCartList()) {
            if (p.getStatus() == 0) {
                check = false;
                break;
            } else check = true;
            break;
        }
        return check;
    }

    public void updateCart() {
        for (CartProductDto p : cartRepository.getProductInCartList()) {
            Optional<Product> product = productRepository.findById(p.getProduct_id());
            p.setPrice(product.get().getPrice());
            p.setProduct_name(product.get().getProduct_name());
            if (productService.checkAvailableProduct(p.getProduct_id(), p.getQuantity())) {
                p.setStatus(1);
            } else p.setStatus(0);
        }
    }
}
