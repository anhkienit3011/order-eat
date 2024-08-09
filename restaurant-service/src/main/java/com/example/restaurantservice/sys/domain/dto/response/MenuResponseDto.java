package com.example.restaurantservice.sys.domain.dto.response;

import java.util.List;

public class MenuResponseDto {
    Integer restaurantId;
    String name;
    String description;
    List<MenuItemResponseDto> menuItems;
}
