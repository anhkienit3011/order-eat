package com.example.userservice.sys.domain.dto;

import jakarta.annotation.Nullable;

import java.math.BigDecimal;

public class MenuItem {
    Integer id;
    int menuId;
    String name;
    @Nullable
    String description;
    BigDecimal price;
}
