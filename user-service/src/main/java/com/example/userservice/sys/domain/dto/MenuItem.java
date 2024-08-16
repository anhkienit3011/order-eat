package com.example.userservice.sys.domain.dto;

import java.math.BigDecimal;

import jakarta.annotation.Nullable;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuItem {
    Integer id;
    int menuId;
    String name;

    @Nullable
    String description;

    BigDecimal price;


}
