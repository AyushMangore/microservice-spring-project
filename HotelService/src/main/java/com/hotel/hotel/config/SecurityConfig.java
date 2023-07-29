/**
 * @Author Ayush Mangore
 * Security configuration class for handling web security settings.
 */
package com.hotel.hotel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    /**
     * Bean definition for the SecurityFilterChain.
     * Configures security for HTTP requests and enables OAuth2 Resource Server with JWT (JSON Web Token) support.
     *
     * @param security The HttpSecurity object to configure security settings.
     * @return The configured SecurityFilterChain.
     * @throws Exception If an error occurs while configuring security settings.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        security
                .authorizeHttpRequests()
                .anyRequest().authenticated()
                // Configures authorization for any request, requiring the user to be authenticated.

                .and()
                .oauth2ResourceServer()
                .jwt();
        // Enables OAuth2 Resource Server support with JWT (JSON Web Token) authentication.

        return security.build();
        // Builds and returns the configured SecurityFilterChain.
    }
}
