package com.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
* @Author Ayush Mangore
* This class is an entity class representing attributes of Hotel
* */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    private String id;
    private String name;
    private String location;
    private String about;
}
