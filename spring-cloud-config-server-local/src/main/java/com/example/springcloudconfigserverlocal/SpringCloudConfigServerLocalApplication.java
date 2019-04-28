package com.example.springcloudconfigserverlocal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServerLocalApplication {

	/**
	 * 启动后访问：@link{http://localhost:8899/order-service/order-service-pro.yml}
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerLocalApplication.class, args);
	}

}
