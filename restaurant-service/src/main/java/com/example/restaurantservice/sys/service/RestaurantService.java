package com.example.restaurantservice.sys.service;

import com.example.restaurantservice.sys.domain.dto.RestaurantProjection;
import com.example.restaurantservice.sys.domain.dto.request.RestaurantRequestDto;
import com.example.restaurantservice.sys.domain.dto.response.RestaurantResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestaurantService {
    ResponseEntity<List<RestaurantResponseDto>> getRestaurants();
    ResponseEntity<List<RestaurantResponseDto>> getRestaurantsWithMenus();
    ResponseEntity<RestaurantResponseDto> findRestaurantByName(String name);
    ResponseEntity<RestaurantResponseDto>findByPhone(String phone);
    ResponseEntity<List<RestaurantResponseDto>>findByAddress(String address);
    ResponseEntity<HttpStatus> addRestaurant(RestaurantRequestDto request);
    ResponseEntity<List<RestaurantProjection>> findRestaurantsByIds(List<Integer> ids);
}
