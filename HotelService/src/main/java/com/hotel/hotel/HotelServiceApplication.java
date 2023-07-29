/**
 * @Author Ayush Mangore
 * Main application class for the Hotel Service.
 */
package com.hotel.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotelServiceApplication {

	/**
	 * The main method of the HotelServiceApplication class.
	 *
	 * @param args Command-line arguments passed to the application (if any).
	 */
	public static void main(String[] args) {
		SpringApplication.run(HotelServiceApplication.class, args);
		// Start the Spring Boot application and run the HotelServiceApplication class.
		// The @SpringBootApplication annotation enables auto-configuration and component scanning.
		// The @EnableEurekaClient annotation registers the application as a Eureka client for service discovery.
	}
}
