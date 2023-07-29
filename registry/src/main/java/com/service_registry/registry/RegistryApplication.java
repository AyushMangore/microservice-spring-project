/**
 * @Authir Ayush Mangore
 * Main Spring Boot application class for the Eureka Service Registry.
 */
package com.service_registry.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/*
* @EnableEurekaServer
* This annotation indicates that the application will act as a Eureka Service Registry.
* Eureka Server is responsible for maintaining a registry of microservices that can be discovered by other services.
* */
@SpringBootApplication
@EnableEurekaServer
public class RegistryApplication {

	/**
	 * Main method to start the Spring Boot application for the Eureka Service Registry.
	 *
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(RegistryApplication.class, args);
	}

}
