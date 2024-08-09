package com.example.restaurantservice.sys.domain.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuItemRequestDto {
    Integer menuId;
    String name;
    String description;
    BigDecimal price;

}
