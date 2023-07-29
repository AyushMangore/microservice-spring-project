package com.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.entities.Hotel;
/*
* @Author Ayush Mangore
* FeignClient is a Declarative REST Client in Spring Boot Web Application.
* Declarative REST Client means you just give the client specification as an
* Interface and spring boot takes care of the implementation for you.
* FeignClient is used to consume RESTFul API endpoints exposed by third-party or microservice
* With the help of feign client only we are making rest API request to other microservice, here for hotel service
* */
@FeignClient(name = "HOTEL-SERVICE")
@Service
public interface HotelService {
    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);
}
