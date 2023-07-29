package com.user.service.payload;

import lombok.*;
import org.springframework.http.HttpStatus;
/*
* @Author Ayush Mangore
* This is the class to represent the API response which includes the message, status of the request.
* */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
}
