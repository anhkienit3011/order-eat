package com.example.shopservice.sys.domain.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantRequestDto {
    String name;
    String description;
    String address;
    String phone;
    String email;
}
