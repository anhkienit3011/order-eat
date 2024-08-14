package com.example.identityservice.sys.domain.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) // all fields are private
public class RestaurantCreationRequest {


    String name;
    String userId;
    String description;
    String address;
    String phone;
    String email;
}
