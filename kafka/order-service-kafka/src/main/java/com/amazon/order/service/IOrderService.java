package com.amazon.order.service;

import org.springframework.stereotype.Service;

import com.amazon.order.request.OrderRequest;

@Service
public interface IOrderService {

	public String createOrder(OrderRequest request);

	public int getOrder(Integer id);

	public String updateOrder(Integer id, OrderRequest orderRequest);
}
