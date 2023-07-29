/**
 * @Author Ayush Mangore
 * Configuration class, WebSecurityConfig, for setting up OAuth2 security and authorization for the application.
 */
package com.user.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    /**
     * Configures the security filter chain to enable OAuth2 resource server and JWT-based authentication.
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
