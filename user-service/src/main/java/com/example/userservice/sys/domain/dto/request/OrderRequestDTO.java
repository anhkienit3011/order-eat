package com.example.userservice.sys.domain.dto.request;

import java.math.BigDecimal;
import java.util.List;

public class OrderRequestDTO {
    Integer restaurantId;
    String status;
    BigDecimal totalAmount;
    List<OrderItemRequestDTO> orderItems;
}
