package com.backend.integrador;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class IntegradorApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntegradorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(IntegradorApplication.class, args);
        LOGGER.info("Proyecto integrador is now running ...");
    }

}
