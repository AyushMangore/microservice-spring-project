package com.user.service.entities;

import antlr.StringUtils;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 * @Author Ayush Mangore
 * This class is an entity class representing attributes of User
 * It includes the list of ratings as well which this user would have provided to various hotels
 * the information with this entity class is being stored in the database with micro_users table name
 * */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name= "micro_users")
public class User {

    @Id
    @Column(name = "ID")
    private String userId;
    @Column(name = "NAME", length = 20)
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ABOUT")
    private String about;

    // to not to save in database
    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
