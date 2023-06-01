package com.backend.clase23;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Clase23Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Clase23Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Clase23Application.class, args);
        LOGGER.info("Clase 23 is now running ...");
    }

}
