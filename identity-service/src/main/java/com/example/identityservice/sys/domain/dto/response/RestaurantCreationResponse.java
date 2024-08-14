package com.example.identityservice.sys.domain.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) // all fields are private
public class RestaurantCreationResponse {


    String name;
    String description;
    String address;
    String phone;
    String email;
}
