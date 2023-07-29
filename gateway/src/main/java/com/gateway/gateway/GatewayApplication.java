/**
 * Main class for the Gateway service application.
 */
package com.gateway.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {

	/**
	 * Main method to start the Gateway service application.
	 *
	 * @param args Command-line arguments passed to the application (if any).
	 */
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
