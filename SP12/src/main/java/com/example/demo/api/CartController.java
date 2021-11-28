package com.example.demo.api;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Product;
import com.example.demo.model.ProductInCart;
import com.example.demo.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/cart")
public class CartController {
    private final CartService cartService;

    @Autowired
	public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public void addProductToCart(@RequestBody Product product) {
        cartService.addProductToCart(product);
    }

    @GetMapping
	public List<ProductInCart> getCart() {
		return cartService.getCart();
	}

    @GetMapping(path = "{product_id}")
    public Optional<ProductInCart> getProductInCartById(@PathVariable("product_id") String product_id) {
        return cartService.getProductInCartById(product_id);
    }

    @DeleteMapping(path = "{product_id}")
    public void removeProductFromCart(@PathVariable("product_id") String product_id) {
        cartService.removeProductFromCart(product_id);
    }

    @PutMapping(path = "{product_id}")
    public String updateProductQuantityInCart(@PathVariable("product_id") String product_id, @RequestBody ProductInCart productInCart) {
        if (cartService.checkAvailableProduct(product_id,productInCart.getQuantity())) { 
            cartService.updateProductQuantityInCart(product_id, productInCart);
            return "Update successfully";
        } else return "Update unsuccessfully";
    }
}