package com.amazon.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.order.entity.OrderEntity;
import com.amazon.order.kafka.service.KafkaProducer;
import com.amazon.order.repository.OrderRepository;
import com.amazon.order.request.OrderRequest;
import com.amazon.order.service.IOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderService implements IOrderService {

	@Autowired
	OrderRepository repository;
	@Autowired
	KafkaProducer kafkaProducer;

	@Override
	public String createOrder(OrderRequest request) {
		OrderEntity entity = new OrderEntity();
		entity.setItemName(request.getItemName());
		entity.setDescription(request.getDescription());
		entity.setStatus(request.getStatus());
		OrderEntity orderEntity = repository.save(entity);

		String orderName = orderEntity.getItemName();
		String message = convertObjToJson(request);

		System.out.println("JSON message sending to Kafka ::: " + message);

//		for (int i = 0; i < 1000; i++) {
//			kafkaProducer.producerMessage("order-data", message + i);
//			System.out.println("Message Sent to kafka: : ");
//		}
		// send message to kafka
		// METHOD-2 Send with KEY
		for (int i = 1; i <= 10; i++) {
			if (i <= 5) {

				// METHOD-1: simple send
//				kafkaProducer.producerMessage("order_success", message + "-" + i);
				// METHOD-2 Send with KEY
//				kafkaProducer.producerMessageWithKey("order_success", "ORD1", message + "-" + i);
				// METHOD-3: send to specific partition
//				kafkaProducer.producerMessageToPartition("order_success", 1, "ORD1", message + "-" + i);
				// METHOD-4: topic + partition + timestamp + key + message
//				kafkaProducer.producerMessageWithTimestamp("order_success", 2, System.currentTimeMillis(), "ORD1",
//						message + "-" + i);
				// SUCCESS → with ACK
				kafkaProducer.producerMessageWithCallback("order_success", message + "-" + i);
			} else if (i <= 8) {
				// METHOD-1: simple send
//				kafkaProducer.producerMessage("order_payment_hold", message + "-" + i);

				// METHOD-2 Send with KEY
//				kafkaProducer.producerMessageWithKey("order_payment_hold", "ORD1", message + "-" + i);
				// METHOD-3: send to specific partition
//				kafkaProducer.producerMessageToPartition("order_payment_hold", 0, "ORD1", message + "-" + i);
//				kafkaProducer.producerMessageWithTimestamp("order_payment_hold", 3, System.currentTimeMillis(), "ORD1",
//						message + "-" + i);
				// PAYMENT HOLD → with ACK
				kafkaProducer.producerMessageWithCallback("order_payment_hold", message + "-" + i);
			} else {
				// METHOD-1: simple send
//				kafkaProducer.producerMessage("order_payment_failed", message + "-" + i);
				// METHOD-2 Send with KEY
//				kafkaProducer.producerMessageWithKey("order_payment_failed", "ORD1", message + "-" + i);
				// METHOD-3: send to specific partition
//				kafkaProducer.producerMessageToPartition("order_payment_failed", 0, "ORD1", message + "-" + i);
//				kafkaProducer.producerMessageWithTimestamp("order_payment_failed", 1, System.currentTimeMillis(),
//						"ORD1", message + "-" + i);
				// PAYMENT FAILED → with ACK
				kafkaProducer.producerMessageWithCallback("order_payment_failed", message + "-" + i);
			}
		}

		return orderName;
	}

	private String convertObjToJson(OrderRequest request) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(request);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return json;
	}

	@Override
	public int getOrder(Integer id) {

		OrderEntity entity = repository.findById(id).orElse(null);

		int orderId = entity.getId();
		return orderId;
	}

	@Override
	public String updateOrder(Integer id, OrderRequest orderRequest) {
		OrderEntity entity = repository.findById(id).orElse(null);
		entity.setItemName(orderRequest.getItemName());
		entity.setDescription(orderRequest.getDescription());
		entity.setStatus(orderRequest.getStatus());
		OrderEntity orderEntity = repository.save(entity);

		String orderName = orderEntity.getItemName();

		return orderName;
	}

}
