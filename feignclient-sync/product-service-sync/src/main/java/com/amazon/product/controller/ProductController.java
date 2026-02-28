package com.amazon.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.product.entity.ProductEntity;
import com.amazon.product.request.ProductRequest;
import com.amazon.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService service;

	@PostMapping("/createProduct")
	public ProductEntity createProduct(@RequestBody ProductRequest request) {

		return service.addProduct(request);
	}

	@GetMapping("/findById/{id}")
	public ProductEntity getProduct(@PathVariable Long id) {
		return service.getById(id);
	}

	@GetMapping("/findAll")
	public List<ProductEntity> getAllProduct() {
		return service.getAllProducts();
	}

}
