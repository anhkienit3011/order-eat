package com.example.restaurantservice.sys.domain.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantResponseDto {
    Integer id;

    String userId;
    String name;
    String description;
    String address;
    String phone;
    String email;
    List<MenuResponseDto> menus;
}
