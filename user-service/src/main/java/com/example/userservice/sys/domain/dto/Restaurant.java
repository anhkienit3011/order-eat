package com.example.userservice.sys.domain.dto;

import jakarta.annotation.Nullable;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Restaurant {
    Integer id;
    String name;

    @Nullable
    String description;

    String address;

    @Nullable
    String phone;

    String email;
}
