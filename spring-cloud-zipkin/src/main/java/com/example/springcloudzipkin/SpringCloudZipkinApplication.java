package com.example.springcloudzipkin;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class SpringCloudZipkinApplication {

	private static final Logger LOG = Logger.getLogger(SpringCloudZipkinApplication.class.getName());

	/**
	 * 启动前先运行 java -jar zipkin-server-2.10.1-exec.jar
	 * <br>再运行spring-cloud-zipkin2
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipkinApplication.class, args);
	}

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	@RequestMapping("/hi")
	public String callHome() {
		LOG.log(Level.INFO, "calling trace service-hi  ");
		return restTemplate.getForObject("http://localhost:8989/miya", String.class);
	}

	@RequestMapping("/info")
	public String info(){
		LOG.log(Level.INFO, "calling trace service-hi ");
		return "i'm service-hi";

	}

}
