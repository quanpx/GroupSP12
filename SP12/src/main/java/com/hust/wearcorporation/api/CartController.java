package com.hust.wearcorporation.api;

import java.util.List;
import java.util.Optional;

import com.hust.wearcorporation.dto.CartProductDto;
import com.hust.wearcorporation.entity.Product;
import com.hust.wearcorporation.service.impl.CartServiceImpl;

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
    private final CartServiceImpl cartService;

    @Autowired
	public CartController(CartServiceImpl cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public void addProductToCart(@RequestBody Product product) {
        cartService.addProductToCart(product);
    }

    @GetMapping
	public List<CartProductDto> getCart() {
		return cartService.getCart();
	}

    @GetMapping(path = "{product_id}")
    public Optional<CartProductDto> getProductInCartById(@PathVariable("product_id") String product_id) {
        return cartService.getProductInCartById(product_id);
    }

    @DeleteMapping(path = "{product_id}")
    public void removeProductFromCart(@PathVariable("product_id") String product_id) {
        cartService.removeProductFromCart(product_id);
    }

    @PutMapping(path = "{product_id}")
    public String updateProductQuantityInCart(@PathVariable("product_id") String product_id, @RequestBody CartProductDto productInCart) {
        return cartService.updateProductQuantityInCart(product_id, productInCart);
    }

    @DeleteMapping
    public void makeEmptyCart() {
        cartService.makeEmptyCart();
    }
}