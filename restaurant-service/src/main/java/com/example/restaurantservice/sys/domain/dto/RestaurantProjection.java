package com.example.restaurantservice.sys.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantProjection {
    Integer id;
    String userId;
    String name;
    String description;
    String address;
    String phone;
    String email;
}
