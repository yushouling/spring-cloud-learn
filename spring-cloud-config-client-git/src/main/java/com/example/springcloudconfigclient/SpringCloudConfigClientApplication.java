package com.example.springcloudconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudConfigClientApplication {

	/**
	 * 启动前先启动 config-server:8888服务
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
	}

	@Value("${foo}")
	String foo;

	@GetMapping("/foo")
	public String getConfig() {
		return "从config-server获取到属性foo=" + foo;
	}

}
