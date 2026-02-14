package com.mazon.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class D01P01EurekaServerBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(D01P01EurekaServerBasicApplication.class, args);
	}

}
