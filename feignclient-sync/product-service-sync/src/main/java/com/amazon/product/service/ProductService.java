package com.amazon.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.product.entity.ProductEntity;
import com.amazon.product.repository.ProductRepository;
import com.amazon.product.request.ProductRequest;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;

	public ProductEntity addProduct(ProductRequest request) {
		ProductEntity entity = new ProductEntity();
		entity.setName(request.getName());
		entity.setPrice(request.getPrice());
		entity.setAvailable(request.isAvailable());
		return repository.save(entity);

	}

	public ProductEntity getById(Long id) {
		return repository.findById(id).orElse(null);

	}

	public List<ProductEntity> getAllProducts() {
		return repository.findAll();
	}

}
