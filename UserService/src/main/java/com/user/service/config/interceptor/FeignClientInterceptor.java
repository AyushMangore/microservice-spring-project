/**
 * @Author Ayush Mangore
 * Feign client interceptor, responsible for adding the OAuth2 access token as an "Authorization" header to outgoing requests.
 */
package com.user.service.config.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class FeignClientInterceptor implements RequestInterceptor {

    @Autowired
    private OAuth2AuthorizedClientManager manager;

    /**
     * Applies the OAuth2 access token as an "Authorization" header to the outgoing Feign client request.
     *
     * @param requestTemplate The template representing the outgoing Feign request.
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        // Authorize the request and retrieve the access token from the OAuth2AuthorizedClientManager
        String token = manager.authorize(OAuth2AuthorizeRequest
                        .withClientRegistrationId("my-internal-client") // Assuming "my-internal-client" is the client registration ID for the internal client
                        .principal("internal") // Assuming "internal" is the principal/user associated with the internal client
                        .build())
                .getAccessToken()
                .getTokenValue();

        // Add the access token as the "Authorization" header to the request
        requestTemplate.header("Authorization", "Bearer " + token);
    }
}
