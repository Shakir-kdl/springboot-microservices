package com.amazon.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Day10Project02SpringEurekaUserServiceSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day10Project02SpringEurekaUserServiceSampleApplication.class, args);
	}

}
