package com.user.service.controllers;

import com.user.service.entities.User;
import com.user.service.services.UserService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
* @Author Ayush Mangore
* This controller class handles various API requests to create, get all users or to get a specific user
* */


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    // create user
    // this method specifically handles the request to create the user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    // get
    // this method handles the request to get a specific user with the help of the user id
    @GetMapping("/{userId}")
    // @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallBack")
    // @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallBack")
    // Below rate limiter is specifically for fault tolerance, whose configuration is defined in application.yml file
    // when this request fails we are calling the fall back method which in turn sends a dummy user data as response
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        // retryCount++;
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }
    // ratingHotelFallBack method
    public ResponseEntity<User> ratingHotelFallBack(String userId, Exception ex){
        ex.printStackTrace();
        User user = User.builder().email("fallback_user@gmail.in").name("fallback").about("dummy user as service is down")
        .userId("0000000").build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    // get all the users, this method handles the API request to retrieve all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

}
