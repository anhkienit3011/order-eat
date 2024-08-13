package com.example.userservice.sys.domain.dto.response;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Builder
public class OrderResponseDTO {
    Integer id;
    int userId;
    int restaurantId;
    String status;
    BigDecimal totalAmount;

    LocalDateTime createAt;
    List<OrderItemResponseDTO> orderItems;
}
