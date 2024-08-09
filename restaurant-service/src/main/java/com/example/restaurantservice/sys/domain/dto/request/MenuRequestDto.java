package com.example.restaurantservice.sys.domain.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuRequestDto {
    Integer restaurantId = 0;
    String name;
    String description;
}
