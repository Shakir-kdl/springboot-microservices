package com.amazon.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazon.product.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
