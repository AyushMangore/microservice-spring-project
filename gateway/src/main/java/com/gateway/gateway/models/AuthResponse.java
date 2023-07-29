/**
 * @Author Ayush Mangore
 * Model class representing the authentication response sent by the Gateway service to the client.
 */
package com.gateway.gateway.models;

import lombok.*;

import java.util.Collection;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthResponse {
    // User ID associated with the authenticated user.
    private String userId;

    // Access token obtained after successful authentication.
    private String accessToken;

    // Refresh token obtained after successful authentication (used to obtain new access tokens).
    private String refreshToken;

    // Timestamp (in seconds) indicating when the access token will expire.
    private long expireAt;

    // Collection of authorities or roles associated with the authenticated user.
    private Collection<String> authorities;
}
