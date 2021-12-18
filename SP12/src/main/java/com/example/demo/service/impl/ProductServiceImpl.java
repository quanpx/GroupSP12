package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.ProductRepository;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	private final ProductRepository productRepository;

	@Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public boolean checkAvailableProduct(String product_id, int value) {
        Optional<Product> product = productRepository.findById(product_id);
        if (product.get().getQuantity_storage() >= value) {
            return true;
        } else return false;
    }
}
