package com.codejudge.moviebooking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieBookingApplication {
	//private static final Logger LOGGER = LogManager.getLogger(MovieBookingApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MovieBookingApplication.class, args);
		/*
		 * LOGGER.info("--MoiveBookingApplication is running"); LOGGER.info("okay");
		 */
	}

}
