/**
 * @Author Ayush Mangore
 * Entity class representing a Hotel.
 */
package com.hotel.hotel.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    private String id;       // Unique identifier (primary key) for the hotel
    private String name;     // Name of the hotel
    private String location; // Location of the hotel
    private String about;    // Information/description about the hotel
}
