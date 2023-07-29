/**
 * Entity class representing a Rating object.
 * This class is mapped to a MongoDB document named "user_ratings".
 */
package com.rating.rating.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document("user_ratings")
public class Rating {
    // MongoDB identifier field
    @Id
    private String ratingId;

    // ID of the user who submitted the rating
    private String userId;

    // ID of the hotel being rated
    private String hotelId;

    // The rating value given by the user
    private int rating;

    // Feedback or comments provided by the user (optional)
    private String feedback;
}
