package com.example.userservice.sys.domain.dto;

import jakarta.annotation.Nullable;

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
