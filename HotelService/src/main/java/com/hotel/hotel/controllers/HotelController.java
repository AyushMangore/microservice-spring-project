/**
 * Controller class for handling HTTP requests related to hotels.
 */
package com.hotel.hotel.controllers;

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

import com.hotel.hotel.entities.Hotel;
import com.hotel.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    /**
     * HTTP POST method for creating a new hotel.
     *
     * @param hotel The Hotel object to be created.
     * @return ResponseEntity with the created Hotel object and HTTP status code 201 (CREATED).
     */
    //It is secured with @PreAuthorize("hasAuthority('Admin')"),
    //which means only users with the "Admin" authority can access it.
    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    /**
     * HTTP GET method for retrieving a single hotel by its id.
     *
     * @param hotelId The id of the hotel to be retrieved.
     * @return ResponseEntity with the retrieved Hotel object and HTTP status code 200 (OK).
     */
    @PreAuthorize("hasAuthority('SCOPE_internal')")
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
    }

    /**
     * HTTP GET method for retrieving all hotels.
     *
     * @return ResponseEntity with a list of all hotels and HTTP status code 200 (OK).
     */
    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll() {
        return ResponseEntity.ok(hotelService.getAll());
    }
}
