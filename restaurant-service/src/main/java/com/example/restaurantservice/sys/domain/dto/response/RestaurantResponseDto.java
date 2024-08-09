package com.example.restaurantservice.sys.domain.dto.response;

import java.util.List;

public class RestaurantResponseDto {
    Integer id;
    String name;
    String description;
    String address;
    String phone;
    String email;
    List<MenuResponseDto> menus;
}
