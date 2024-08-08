package com.example.shopservice.sys.domain.mapper;
import com.example.shopservice.sys.domain.dto.request.MenuRequestDto;
import com.example.shopservice.sys.domain.dto.request.RestaurantRequestDto;
import com.example.shopservice.sys.domain.dto.response.MenuResponseDto;
import com.example.shopservice.sys.domain.dto.response.RestaurantResponseDto;
import com.example.shopservice.sys.domain.entity.Menu;
import com.example.shopservice.sys.domain.entity.Restaurant;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring") // to use in spring (DI)
public interface RestaurantMapper {
    Restaurant toRestaurant (RestaurantRequestDto request);
    RestaurantResponseDto toRestaurantResponse (Restaurant restaurant);
}
