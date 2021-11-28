package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.ProductRepository;
import com.example.demo.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	@Autowired
    public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}
}
