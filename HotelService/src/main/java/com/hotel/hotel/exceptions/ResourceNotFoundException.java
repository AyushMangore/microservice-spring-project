/**
 * @Author Ayush Mangore
 * Custom exception class for representing a resource not found exception.
 * This exception can be thrown when a requested resource is not found.
 */
package com.hotel.hotel.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructor with a custom error message.
     *
     * @param s The custom error message for the exception.
     */
    public ResourceNotFoundException(String s) {
        super(s);
        // Calls the constructor of the superclass (RuntimeException) with the custom error message.
    }

    /**
     * Default constructor with a predefined error message.
     * This constructor is called when no specific error message is provided.
     */
    public ResourceNotFoundException() {
        super("Resource Not Found !!");
        // Calls the constructor of the superclass (RuntimeException) with a predefined error message.
    }
}
