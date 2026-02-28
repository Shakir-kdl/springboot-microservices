package com.amazon.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.order.request.OrderRequest;
import com.amazon.order.service.IOrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	IOrderService iOrderService;

	@PostMapping("/createOrder")
	public String createOrder(@RequestBody OrderRequest request) {

		String orderName = iOrderService.createOrder(request);
		return "Order Created: " + orderName;
	}

	@GetMapping("/findById")
	public String getOrderById(@RequestParam Integer id) {
		int orderId = iOrderService.getOrder(id);

		return "Order Get By Id: " + orderId;
	}

	@PutMapping("/update")
	public String updateOrder(@RequestParam Integer id, @RequestBody OrderRequest orderRequest) {

		String orderName = iOrderService.updateOrder(id, orderRequest);
		return "Order Name Updated: " + orderName;
	}
}
