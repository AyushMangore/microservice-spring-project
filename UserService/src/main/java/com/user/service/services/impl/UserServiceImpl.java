package com.user.service.services.impl;

import com.user.service.entities.Hotel;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.external.services.HotelService;
import com.user.service.repositories.UserRepository;
import com.user.service.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
/*
* This is the implementation class for user service interface, defines the logic for the declared methods
* the object of userRepository has been autowired according to the standard of spring
* inside this service we are making calls to various other services with the help of rest template
* */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        // get user with id
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with the particular id not found !! ID : "+ userId));
        // fetch rating of above user
        // http://localhost:8083/ratings/users/d42f9e5e-9f23-47ff-8339-f04ba1a08697
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(),Rating[].class);
        logger.info("{} ",ratingsOfUser);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).collect(Collectors.toList());

        List<Rating> ratingList = ratings.stream().map(rating -> {
            // api call to hotel service to get the hotel
            // http://localhost:8082/hotels/19da1190-d0ac-4d3e-ba64-8ec4a83de230
            // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(),Hotel.class);
            // Hotel hotel = forEntity.getBody();
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            // logger.info("Response status code : {}",forEntity.getStatusCode());
            // set hotelto rating
            rating.setHotel(hotel);
            // return the rating
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratings);
        return user;
    }
}
