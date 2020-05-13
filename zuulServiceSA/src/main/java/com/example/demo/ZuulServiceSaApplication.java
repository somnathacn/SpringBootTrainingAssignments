package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulServiceSaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceSaApplication.class, args);
	}

}
