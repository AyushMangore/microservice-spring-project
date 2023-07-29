/**
 * Main class to bootstrap the Rating Service application.
 */
package com.rating.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*
* @EnableEurekaClient
* This annotation indicates that the application is a Eureka client,
* which registers with the Eureka server for service discovery.
* */
@SpringBootApplication
@EnableEurekaClient
public class RatingApplication {

	/**
	 * Main method to start the Rating Service application.
	 *
	 * @param args Command-line arguments (if any).
	 */
	public static void main(String[] args) {
		SpringApplication.run(RatingApplication.class, args);
	}
}
