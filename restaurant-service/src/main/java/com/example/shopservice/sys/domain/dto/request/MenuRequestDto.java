package com.example.shopservice.sys.domain.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuRequestDto {
    Integer restaurantId;
    String name;
    String description;
}
