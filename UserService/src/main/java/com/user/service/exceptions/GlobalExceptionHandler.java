package com.user.service.exceptions;

import com.user.service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/*
* @Author Ayush Mangore
* It is a standard abd kind of interceptor that surrounds the logic in our Controllers and
* allows us to apply some common logic to them. Rest Controller Advice's methods
* (annotated with @ExceptionHandler ) are shared globally across multiple @Controller
* components to capture exceptions and translate them to HTTP responses
* */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception){
        String message = exception.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
    }
}
