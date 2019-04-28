package com.example.springcloudclientribbon.test;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "errorMethod")
	public String sayHello(String name) {
		return restTemplate.getForObject("http://service.order-service-hi/hi?name=" + name, String.class);
	}

	public String errorMethod(String name) {
		return "Hystrix error return! name:" + name;
	}
}
