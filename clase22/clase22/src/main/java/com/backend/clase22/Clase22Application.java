package com.backend.clase22;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Clase22Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Clase22Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Clase22Application.class, args);
		LOGGER.info("The application is now running...");
	}

}
