package com.amazon.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.order.entity.OrderEntity;
import com.amazon.order.request.OrderRequest;
import com.amazon.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/createOrder")
	public OrderEntity createOrder(@RequestBody OrderRequest request) {

		return orderService.createOrder(request);

	}

	@GetMapping("/findById/{id}")
	public OrderEntity getOrder(@PathVariable Long id) {
		return orderService.getOrder(id);
	}

}
