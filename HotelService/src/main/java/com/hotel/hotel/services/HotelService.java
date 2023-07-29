/**
 * @Author Ayush Mangore
 * Service interface for Hotel-related operations.
 */
package com.hotel.hotel.services;

import java.util.List;

import com.hotel.hotel.entities.Hotel;

public interface HotelService {

    /**
     * Create a new hotel.
     *
     * @param hotel The Hotel object to be created.
     * @return The newly created Hotel object.
     */
    Hotel create(Hotel hotel);

    /**
     * Get a list of all hotels.
     *
     * @return A list containing all Hotel objects.
     */
    List<Hotel> getAll();

    /**
     * Get a single hotel by its id.
     *
     * @param id The id of the hotel to be retrieved.
     * @return The Hotel object with the specified id.
     */
    Hotel get(String id);
}
