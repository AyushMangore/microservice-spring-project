/**
 * @Author Ayush Mangore
 * Controller class for handling HTTP requests related to ratings.
 */
package com.rating.rating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.rating.entities.Rating;
import com.rating.rating.services.RatingService;

@RestController
@RequestMapping("ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    /**
     * Endpoint for creating a new rating.
     * Requires the user to have the 'Admin' authority.
     *
     * @param rating The rating object to be created.
     * @return ResponseEntity with the created rating and HTTP status 201 (CREATED).
     */
    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    /**
     * Endpoint for retrieving all ratings.
     *
     * @return ResponseEntity with the list of all ratings and HTTP status 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
        return ResponseEntity.ok(ratingService.getRatings());
    }

    /**
     * Endpoint for retrieving ratings by user id.
     * Requires the user to have either 'SCOPE_internal' or 'Admin' authority.
     *
     * @param userId The id of the user for whom ratings are to be retrieved.
     * @return ResponseEntity with the list of ratings for the specified user and HTTP status 200 (OK).
     */
    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    /**
     * Endpoint for retrieving ratings by hotel id.
     *
     * @param hotelId The id of the hotel for which ratings are to be retrieved.
     * @return ResponseEntity with the list of ratings for the specified hotel and HTTP status 200 (OK).
     */
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }
}
