package com.backend.clase21;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Clase21Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Clase21Application.class);
	public static void main(String[] args) {

		SpringApplication.run(Clase21Application.class, args);
		LOGGER.info("Nuestra primer aplicacion de SpringBoot");
	}

	@GetMapping("hola")
	public String saludar(){
		String saludo = "Hola camada 9";
		LOGGER.info(saludo);
		return saludo;
	}

}
