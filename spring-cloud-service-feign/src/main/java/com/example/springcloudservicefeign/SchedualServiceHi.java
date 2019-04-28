package com.example.springcloudservicefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service.order-service-hi")
public interface SchedualServiceHi {

	@GetMapping("/hi")
	String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
