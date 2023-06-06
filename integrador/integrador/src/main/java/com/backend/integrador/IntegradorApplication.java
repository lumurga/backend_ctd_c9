package com.backend.integrador;

import com.backend.integrador.dao.H2Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class IntegradorApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntegradorApplication.class);

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        H2Connection.crearBd();
        SpringApplication.run(IntegradorApplication.class, args);
        LOGGER.info("Proyecto integrador is now running ...");
    }

}
