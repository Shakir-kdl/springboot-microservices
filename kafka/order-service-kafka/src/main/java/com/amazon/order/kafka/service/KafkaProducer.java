package com.amazon.order.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

	// METHOD-1: Simple Send
//	@Autowired
//	KafkaTemplate<String, String> kafkaTemplate;
//
//	public void producerMessage(String _topic, String _message) {
//		kafkaTemplate.send(_topic, _message);
//	}

	// METHOD-2 Send with KEY
//	@Autowired
//	KafkaTemplate<String, String> kafkaTemplate;
//	public void producerMessageWithHardcodedKey(String topic, String message) {
//	    kafkaTemplate.send(topic, "ORD1", message);   // 🔒 hardcoded key
//	}
	// METHOD-3: send to specific partition
//	@Autowired
//	KafkaTemplate<String, String> kafkaTemplate;
//
//	public void producerMessageToPartition(String topic, int partition, String key, String message) {
//		kafkaTemplate.send(topic, partition, key, message);
//	}

	// METHOD-4: topic + partition + timestamp + key + message
//	

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	public void producerMessageWithCallback(String topic, String message) {

		kafkaTemplate.send(topic, message).whenComplete((result, ex) -> {

			if (ex == null) {
				System.out.println("ACK RECEIVED ✔ topic=" + topic + " partition="
						+ result.getRecordMetadata().partition() + " offset=" + result.getRecordMetadata().offset());
			} else {
				System.out.println("ACK FAILED ❌ topic=" + topic + " error=" + ex.getMessage());
			}
		});
	}

}
