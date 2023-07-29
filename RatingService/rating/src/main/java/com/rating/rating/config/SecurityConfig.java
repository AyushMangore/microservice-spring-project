/**
 * @Author Ayush Mangore
 * Security configuration class for the Rating Service.
 */
package com.rating.rating.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.server.WebFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    /**
     * Configures security filters for the Rating Service endpoints.
     *
     * @param security The HttpSecurity object used to configure security settings.
     * @return The configured SecurityFilterChain.
     * @throws Exception If an exception occurs during configuration.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        security
                // Authorize all HTTP requests to require authentication
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                // Configure OAuth2 resource server for JWT-based authentication
                .oauth2ResourceServer()
                .jwt();
        // Build and return the configured SecurityFilterChain
        return security.build();
    }
}
