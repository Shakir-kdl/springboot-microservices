package com.quickbite.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Day10Project02QuickbiteUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day10Project02QuickbiteUserServiceApplication.class, args);
	}

}
