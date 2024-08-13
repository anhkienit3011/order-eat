package com.example.userservice.sys.domain.dto.response;

import com.example.userservice.sys.domain.dto.Restaurant;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Builder
public class OrderResponseWithRestaurantDTO {
    Integer id;
    int userId;
    Restaurant restaurant;
    String status;
    BigDecimal totalAmount;

    LocalDateTime createAt;
    List<OrderItemResponseDTO> orderItems;
}
