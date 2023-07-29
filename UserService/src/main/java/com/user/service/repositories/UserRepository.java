package com.user.service.repositories;


import com.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
/*
* This is the user repository interface facilitating various pre defined methods to query the database
* */
public interface UserRepository extends JpaRepository<User,String> {
    // custom method can be created
}
