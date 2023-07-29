/**
 * @Author Ayush Mangore
 * Controller class for handling authentication-related endpoints.
 */
package com.gateway.gateway.controllers;

import com.gateway.gateway.models.AuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    /**
     * Endpoint for handling user login and generating authentication response.
     *
     * @param client The OAuth2AuthorizedClient registered with the "okta" client registration.
     * @param user The authenticated user information (OidcUser).
     * @param model The Spring Model to add attributes.
     * @return ResponseEntity containing the authentication response with user details and access token.
     */
    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OidcUser user,
            Model model
    ) {
        // Log the email id of the authenticated user
        logger.info("User Email Id: {}", user.getEmail());

        // Create the AuthResponse object
        AuthResponse authResponse = new AuthResponse();

        // Set the user's email to the AuthResponse
        authResponse.setUserId(user.getEmail());

        // Set the access token and refresh token to the AuthResponse
        authResponse.setAccessToken(client.getAccessToken().getTokenValue());
        authResponse.setRefreshToken(client.getRefreshToken().getTokenValue());

        // Set the token expiration timestamp to the AuthResponse
        authResponse.setExpireAt(client.getAccessToken().getExpiresAt().getEpochSecond());

        // Get the user's authorities and set them to the AuthResponse
        List<String> authorities = user.getAuthorities().stream().map(grantedAuthority -> {
            return grantedAuthority.getAuthority();
        }).collect(Collectors.toList());
        authResponse.setAuthorities(authorities);

        // Return the AuthResponse in a ResponseEntity with HttpStatus OK
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }
}
