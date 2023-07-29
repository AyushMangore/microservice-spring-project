/**
 * @Author Ayush Mangore
 * Repository interface for accessing and managing Hotel entities in the database.
 */
package com.hotel.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

    // This interface extends JpaRepository, which provides CRUD operations for the Hotel entity.

    // No additional custom methods are defined here, as JpaRepository provides all necessary methods.
    // It supports querying, saving, updating, and deleting Hotel entities from the database.
}
