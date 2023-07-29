/**
 * @Author Ayush Mangore
 * Configuration class, MyConfig, sets up a load-balanced RestTemplate with OAuth2 client authentication using Spring Security.
 * This configuration allows the RestTemplate to securely communicate with other services in the system using the OAuth2 client credentials grant type.
 * The RestTemplate is annotated with @LoadBalanced, enabling it to distribute requests among multiple instances of the target service.
 */

package com.user.service.config;

import com.netflix.discovery.converters.Auto;
import com.user.service.config.interceptor.RestTemplateInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyConfig {

    // Autowiring the required dependencies for OAuth2 client configuration
    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;
    @Autowired
    private OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository;

    /**
     * Configures a load-balanced RestTemplate with OAuth2 authentication for making requests to other services.
     *
     * @return The configured RestTemplate instance.
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {

        // Creating a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Creating a list to hold request interceptors
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

        // Adding a custom RestTemplateInterceptor that handles OAuth2 client credentials
        interceptors.add(new RestTemplateInterceptor(manager(
                clientRegistrationRepository, oAuth2AuthorizedClientRepository
        )));

        // Setting the request interceptors for the RestTemplate
        restTemplate.setInterceptors(interceptors);

        // Returning the configured RestTemplate
        return restTemplate;
    }

    /**
     * Declaration of a Bean for OAuth2AuthorizedClientManager, which manages OAuth2 client credentials.
     *
     * @param clientRegistrationRepository The repository for client registrations.
     * @param auth2AuthorizedClientRepository The repository for authorized OAuth2 clients.
     * @return The configured OAuth2AuthorizedClientManager instance.
     */
    @Bean
    public OAuth2AuthorizedClientManager manager(
            ClientRegistrationRepository clientRegistrationRepository,
            OAuth2AuthorizedClientRepository auth2AuthorizedClientRepository
    ) {
        // Setting up the OAuth2AuthorizedClientProvider with client credentials grant type
        OAuth2AuthorizedClientProvider provider = OAuth2AuthorizedClientProviderBuilder.builder().clientCredentials().build();

        // Creating and configuring the DefaultOAuth2AuthorizedClientManager with the provided repositories and authorized client provider
        DefaultOAuth2AuthorizedClientManager defaultOAuth2AuthorizedClientManager = new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository, auth2AuthorizedClientRepository);
        defaultOAuth2AuthorizedClientManager.setAuthorizedClientProvider(provider);

        // Returning the fully configured OAuth2AuthorizedClientManager
        return defaultOAuth2AuthorizedClientManager;
    }
}
