package com.example.springcloudeurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope
@RestController
public class SpringCloudEurekaClientBusApplication {

	/**
	 * 发送POST请求更新配置：http://localhost:8881/actuator/bus-refresh
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaClientBusApplication.class, args);
	}
	@Value("${foo}")
	String foo;

	@RequestMapping(value = "/hi")
	public String hi(){
		return foo;
	}

}
