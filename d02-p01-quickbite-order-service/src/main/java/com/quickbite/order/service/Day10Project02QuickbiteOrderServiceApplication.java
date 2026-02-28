package com.quickbite.order.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Day10Project02QuickbiteOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day10Project02QuickbiteOrderServiceApplication.class, args);
	}

}
