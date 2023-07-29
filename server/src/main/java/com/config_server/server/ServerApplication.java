/**
 * Main Spring Boot application class for the Config Server.
 */
package com.config_server.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/*
* @EnableEurekaClient
* This annotation indicates that the application will act as a Eureka client.
* It will register with a Eureka server for service discovery.
* Eureka clients can be discovered and load-balanced by Eureka server.
* @EnableConfigServer
* This annotation enables the application to act as a Config Server.
* It provides centralized configuration management for other microservices in the system.
* The Config Server can fetch and serve configuration properties from various sources, such as Git repositories.
* */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ServerApplication {

	/**
	 * Main method to start the Spring Boot application.
	 *
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}
