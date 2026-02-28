package com.amazon.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazon.order.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
