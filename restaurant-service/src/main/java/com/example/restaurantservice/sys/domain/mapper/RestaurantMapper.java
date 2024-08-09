package com.example.restaurantservice.sys.domain.mapper;

import com.example.restaurantservice.sys.domain.dto.request.RestaurantRequestDto;
import com.example.restaurantservice.sys.domain.dto.response.RestaurantResponseDto;
import com.example.restaurantservice.sys.domain.entity.Restaurant;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring") // to use in spring (DI)
public interface RestaurantMapper {
    Restaurant toRestaurant (RestaurantRequestDto request);
    RestaurantResponseDto toRestaurantResponse (Restaurant restaurant);

    List<RestaurantResponseDto> toListRestaurantResponse (List<Restaurant> restaurants);
}
