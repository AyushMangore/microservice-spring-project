/**
 * @Author Ayush Mangore
 * Service interface for handling business logic related to ratings.
 */
package com.rating.rating.services;

import java.util.List;

import com.rating.rating.entities.Rating;

public interface RatingService {
    // create

    /**
     * Service method for creating a new rating.
     *
     * @param rating The rating object to be created.
     * @return The created rating object.
     */
    Rating create(Rating rating);

    // get all ratings

    /**
     * Service method for retrieving all ratings.
     *
     * @return List of all ratings.
     */
    List<Rating> getRatings();

    // get by user id

    /**
     * Service method for retrieving ratings by user id.
     *
     * @param userId The id of the user for whom ratings are to be retrieved.
     * @return List of ratings for the specified user.
     */
    List<Rating> getRatingByUserId(String userId);

    // get by hotel id

    /**
     * Service method for retrieving ratings by hotel id.
     *
     * @param hotelId The id of the hotel for which ratings are to be retrieved.
     * @return List of ratings for the specified hotel.
     */
    List<Rating> getRatingByHotelId(String hotelId);
}
