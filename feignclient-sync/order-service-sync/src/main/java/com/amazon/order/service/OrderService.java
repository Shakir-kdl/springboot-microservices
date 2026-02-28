package com.amazon.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.order.client.Product;
import com.amazon.order.client.ProductClient;
import com.amazon.order.entity.OrderEntity;
import com.amazon.order.repository.OrderRepository;
import com.amazon.order.request.OrderRequest;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	ProductClient productClient;

	public OrderEntity createOrder(OrderRequest request) {

		Product product = productClient.getProductByID(request.getProductId());
		if (!product.isAvailable()) {
			throw new RuntimeException("Product is not available");
		}
		OrderEntity entity = new OrderEntity();
		entity.setProductId(request.getProductId());
		entity.setQuantity(request.getQuantity());
		entity.setTotalPrice(product.getPrice() * request.getQuantity());
		entity.setOrderStatus("CREATED");
		entity.setEmail(request.getEmail());

		return orderRepository.save(entity);
	}

	public OrderEntity getOrder(Long id) {
		return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

	}
}
