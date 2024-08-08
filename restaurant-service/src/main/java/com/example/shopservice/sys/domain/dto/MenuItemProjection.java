package com.example.shopservice.sys.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuItemProjection {
    Integer menuId;
    String name;
    String description;
    BigDecimal price;

}
