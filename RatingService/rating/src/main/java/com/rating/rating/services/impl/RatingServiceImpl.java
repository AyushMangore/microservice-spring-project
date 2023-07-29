/**
 * @Author Ayush Mangore
 * Implementation class for the RatingService interface.
 * This class provides the actual implementation of the service methods for handling ratings.
 */
package com.rating.rating.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.rating.entities.Rating;
import com.rating.rating.repositories.RatingRepository;
import com.rating.rating.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository repository;

    /**
     * Service method for creating a new rating.
     *
     * @param rating The rating object to be created.
     * @return The created rating object.
     */
    @Override
    public Rating create(Rating rating) {
        return repository.save(rating);
    }

    /**
     * Service method for retrieving all ratings.
     *
     * @return List of all ratings.
     */
    @Override
    public List<Rating> getRatings() {
        return repository.findAll();
    }

    /**
     * Service method for retrieving ratings by user id.
     *
     * @param userId The id of the user for whom ratings are to be retrieved.
     * @return List of ratings for the specified user.
     */
    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    /**
     * Service method for retrieving ratings by hotel id.
     *
     * @param hotelId The id of the hotel for which ratings are to be retrieved.
     * @return List of ratings for the specified hotel.
     */
    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return repository.findByHotelId(hotelId);
    }
}
