package com.example.springcloudeurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

	@Value("${server.port}")
	private String port;

	@GetMapping("/hi")
	public String hi(String name) {
		return "Response from eureka client " + port + " : hi " + name;
	}
}
