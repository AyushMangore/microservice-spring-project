/**
 * @Author Ayush Mangore
 * Repository interface for accessing and managing ratings data in MongoDB.
 */
package com.rating.rating.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rating.rating.entities.Rating;

public interface RatingRepository extends MongoRepository<Rating, String> {
    // custom finder methods

    /**
     * Custom finder method to retrieve ratings by user id.
     *
     * @param userId The id of the user for whom ratings are to be retrieved.
     * @return List of ratings for the specified user.
     */
    List<Rating> findByUserId(String userId);

    /**
     * Custom finder method to retrieve ratings by hotel id.
     *
     * @param hotelId The id of the hotel for which ratings are to be retrieved.
     * @return List of ratings for the specified hotel.
     */
    List<Rating> findByHotelId(String hotelId);
}
