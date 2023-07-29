/**
 * @Author Ayush Mangore
 * Configuration class for Spring Security in the Gateway service using WebFlux.
 */
package com.gateway.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    /**
     * Configures Spring Security for WebFlux to handle OAuth2 authentication and authorization.
     *
     * @param httpSecurity The ServerHttpSecurity instance to configure security for WebFlux.
     * @return The SecurityWebFilterChain instance to handle security filtering and authorization rules.
     */
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
        httpSecurity
                .authorizeExchange()
                .anyExchange().authenticated();
        // Configures the security rules for all the endpoints (Exchange) to require authentication (any authenticated user).

        httpSecurity.oauth2Client();
        // Configures the integration with the OAuth2 Client, enabling the Gateway service to act as an OAuth2 client.

        httpSecurity.oauth2ResourceServer().jwt();
        // Configures the integration with the OAuth2 Resource Server (typically Okta) using JWT (JSON Web Token) validation.

        return httpSecurity.build();
        // Builds and returns the final SecurityWebFilterChain instance with the configured security rules.
    }
}
