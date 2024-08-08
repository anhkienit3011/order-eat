package com.example.shopservice.sys.domain.dto.response;

import java.util.List;

public class MenuResponseDto {
    Long restaurantId;
    String name;
    String description;
    List<MenuItemResponsetDto> menuItems;
}
