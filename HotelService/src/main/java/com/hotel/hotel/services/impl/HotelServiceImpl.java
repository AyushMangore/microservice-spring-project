/**
 * @Authotr Ayush Mangore
 * Implementation of the HotelService interface for handling hotel-related operations.
 */
package com.hotel.hotel.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.entities.Hotel;
import com.hotel.hotel.exceptions.ResourceNotFoundException;
import com.hotel.hotel.repositories.HotelRepository;
import com.hotel.hotel.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    /**
     * Create a new hotel.
     *
     * @param hotel The Hotel object to be created.
     * @return The newly created Hotel object.
     */
    @Override
    public Hotel create(Hotel hotel) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'create'");
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId); // Assign a random UUID as the id for the new hotel.
        return hotelRepository.save(hotel); // Save the hotel entity to the database.
    }

    /**
     * Get a list of all hotels.
     *
     * @return A list containing all Hotel objects.
     */
    @Override
    public List<Hotel> getAll() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAll'");
        return hotelRepository.findAll(); // Retrieve all hotel entities from the database.
    }

    /**
     * Get a single hotel by its id.
     *
     * @param id The id of the hotel to be retrieved.
     * @return The Hotel object with the specified id.
     * @throws ResourceNotFoundException If the hotel with the given id is not found.
     */
    @Override
    public Hotel get(String id) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'get'");
        return hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found !!"));
        // Retrieve the hotel entity from the database with the specified id.
        // If the hotel is not found, throw a ResourceNotFoundException with an appropriate error message.
    }
}
