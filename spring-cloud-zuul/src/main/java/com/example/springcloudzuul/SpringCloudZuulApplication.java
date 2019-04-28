package com.example.springcloudzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class SpringCloudZuulApplication {

	/**
	 * 启动前先自动eureka,ribbon,feign这几个服务
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulApplication.class, args);
	}

}
