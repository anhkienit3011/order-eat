package com.example.restaurantservice.sys.controller;


import com.example.restaurantservice.sys.domain.dto.request.RestaurantRequestDto;
import com.example.restaurantservice.sys.domain.dto.response.RestaurantResponseDto;
import com.example.restaurantservice.sys.service.RestaurantService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RestaurantController {
    RestaurantService restaurantService;

    @PostMapping("/add")
    ResponseEntity<HttpStatus> addRestaurant(@RequestBody RestaurantRequestDto request){
        return restaurantService.addRestaurant(request);
    }

    @GetMapping
    ResponseEntity<List<RestaurantResponseDto>> getRestaurants(){
        return restaurantService.getRestaurants();
    }
}
