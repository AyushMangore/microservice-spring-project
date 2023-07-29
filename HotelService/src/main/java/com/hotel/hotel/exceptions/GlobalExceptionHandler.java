/**
 * @Author Ayush Mangore
 * GlobalExceptionHandler class to handle exceptions globally in the Hotel Service application.
 */
package com.hotel.hotel.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Exception handler for ResourceNotFoundException.
     * This method is responsible for handling ResourceNotFoundExceptions thrown in the application.
     *
     * @param exception The ResourceNotFoundException that occurred.
     * @return ResponseEntity with a JSON response containing details of the exception.
     */
    public ResponseEntity<Map<String, Object>> notFoundHandler(ResourceNotFoundException exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", exception.getMessage());
        // Sets the error message in the response map.

        map.put("success", false);
        // Indicates that the request was not successful due to the exception.

        map.put("status", HttpStatus.NOT_FOUND);
        // Sets the HTTP status code in the response map.

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
        // Returns a ResponseEntity with the response map and HTTP status code 404 (NOT_FOUND).
    }
}
