package com.example.Fleet.Management.software.API;

import org.springframework.boot.SpringApplication; // Importación de la clase SpringApplication de Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importación de la anotación SpringBootApplication de Spring Boot

@SpringBootApplication // Anotación que combina @Configuration, @EnableAutoConfiguration y @ComponentScan

public class FleetManagementSoftwareApiApplication { // Clase principal de la aplicación

	public static void main(String[] args) { // Método principal de la aplicación
		SpringApplication.run(FleetManagementSoftwareApiApplication.class, args); // Inicia la aplicación Spring Boot
	}

}
