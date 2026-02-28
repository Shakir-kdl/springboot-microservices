package com.amazon.notification.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
//public class NotificationConsumerService {
//	@KafkaListener(topics = "order-data", groupId = "cg2")
//	public void consume(String message) {
//
//		System.out.println("Received message :: " + message);
//	}

@Service
public class NotificationConsumerService {

	@KafkaListener(topics = "order_success", groupId = "cg2")
	public void successConsumer(String message) {
		System.out.println("SUCCESS Notification :: " + message);
	}

	@KafkaListener(topics = "order_payment_hold", groupId = "cg2")
	public void holdConsumer(String message) {
		System.out.println("PAYMENT HOLD Notification :: " + message);
	}

	@KafkaListener(topics = "order_payment_failed", groupId = "cg2")
	public void failedConsumer(String message) {
		System.out.println("FAILED Notification :: " + message);
	}
}
