package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.ProductRepository;
import com.example.demo.model.Product;
import com.example.demo.model.ProductInCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public void addProductToCart(Product product) {
        cartRepository.addProductToCart(product);
    }

    public List<ProductInCart> getCart() {
	    for (ProductInCart p: cartRepository.getProductInCartList()) {
              Optional<Product> product = productRepository.findById(p.getProduct_id());
              p.setPrice(product.get().getPrice());
              p.setProduct_name(product.get().getProduct_name());
              if (checkAvailableProduct(p.getProduct_id(),p.getQuantity())) {
                  p.setStatus(1);
              } else p.setStatus(0);
        };
        return cartRepository.getProductInCartList();
	}

    public Optional<ProductInCart> getProductInCartById(String product_id){
        return cartRepository.getProductInCartById(product_id);
    }

    public int removeProductFromCart(String product_id) {
        return cartRepository.removeProductFromCart(product_id);
    }

    public String updateProductQuantityInCart(String product_id, ProductInCart productInCart) {
        if (checkAvailableProduct(product_id,productInCart.getQuantity())) {
            cartRepository.updateProductQuantityInCart(product_id, productInCart);
            return "Update successfully";
        } else return "Update unsuccessfully";
    }

    public boolean checkAvailableProduct(String product_id, int value) {
        Optional<Product> product = productRepository.findById(product_id);
        if (product.get().getQuantity_storage() >= value) {
            return true;
        } else return false;
    }
}
