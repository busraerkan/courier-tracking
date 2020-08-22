package com.busrapamuk.couriertracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"controller","service"})
public class CourierTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourierTrackingApplication.class, args);
	}
}
