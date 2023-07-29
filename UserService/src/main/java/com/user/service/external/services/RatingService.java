package com.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.user.service.entities.Rating;
/*
 * @Author Ayush Mangore
 * FeignClient is a Declarative REST Client in Spring Boot Web Application.
 * Declarative REST Client means you just give the client specification as an
 * Interface and spring boot takes care of the implementation for you.
 * FeignClient is used to consume RESTFul API endpoints exposed by third-party or microservice
 * With the help of feign client only we are making rest API request to other microservice, here for rating service
 * */
@FeignClient(name = "RATING-SERVICE")
@Service
public interface RatingService {
    
    @PostMapping("/ratings")
    Rating createRating(Rating values);

    @PutMapping("ratings/{ratingId}")
    Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

    // @DeleteMapping("ratings/{ratingId}")
    // void deleteRating(@PathVariable Rating rating);
}
