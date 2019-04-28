package com.example.springcloudeurekaclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@RestController
public class SpringCloudEurekaClientHystrixApplication {

	/**
	 * 访问 http://localhost:8762/hystrix 后，文本框里输入 http://localhost:8762/actuator/hystrix.stream
	 * 访问 http://localhost:8762/hi?name=Stanley 监控将产生数据
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaClientHystrixApplication.class, args);
	}

	@Value("${server.port}")
	private String port;

	@GetMapping("/hi")
	@HystrixCommand(fallbackMethod = "errorMethod")
	public String hi(String name) {
		if(new Random().nextInt(10) <= 5) {
			System.out.println("发生异常!");
			throw new RuntimeException();
		}
		return "Response from eureka client " + port + " : hi " + name;
	}

	public String errorMethod(String name) {
		return "Server error, return default value.";
	}

}
