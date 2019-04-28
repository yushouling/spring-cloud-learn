package com.example.springcloudconfigclientlocal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudConfigClientLocalApplication {

	/**
	 * 启动前先启动 config-server-local
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientLocalApplication.class, args);
	}

	@Value("${jdbc.url.username}")
	String userName;

	@GetMapping("/user")
	public String getConfig() {
		return "从config-server获取到本地属性user=" + userName;
	}

}
