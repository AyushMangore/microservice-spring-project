package com.user.service.services;

//import com.user.service.entities.User;

import com.user.service.entities.User;

import java.util.List;
/*
* @Author Ayush Mangore
* This is the user service interface contains the declaration of, various methods to create, retrieve the users
* implementation and definition of all these methods can be found in impl section classes
* */
public interface UserService {
    // user operation

    // create
    User saveUser(User user);

    // get all user
    List<User> getAllUser();

    // get user
    User getUser(String userId);

    // to do DELETE and UPDATE
}
