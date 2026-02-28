package com.quickbite.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Day10Project02QuickbitePlatformEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day10Project02QuickbitePlatformEurekaServerApplication.class, args);
	}

}
