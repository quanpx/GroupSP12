package com.hust.wearcorporation.api;

import java.util.List;

import com.hust.wearcorporation.entity.Product;
import com.hust.wearcorporation.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    private ProductService productService;

    @Autowired
	public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
	public List<Product> getProducts() {
		return productService.getProducts();
	}
}
