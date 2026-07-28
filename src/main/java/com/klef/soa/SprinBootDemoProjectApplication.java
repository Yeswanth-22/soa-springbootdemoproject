package com.klef.soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SprinBootDemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprinBootDemoProjectApplication.class, args);
		System.out.println("project is runing......!!!");
	}
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
