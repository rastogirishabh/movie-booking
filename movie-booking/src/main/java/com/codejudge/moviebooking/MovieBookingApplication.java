package com.codejudge.moviebooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class MovieBookingApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MovieBookingApplication.class, args);
		
	}

}
