package com.amazon.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.amazon.order.config.TracingFeignConfig;

@FeignClient(name = "product-service-sync", configuration = TracingFeignConfig.class)
public interface ProductClient {
	@GetMapping("/products/findById/{id}")
	Product getProductByID(@PathVariable("id") Long id);

}
