package com.example.userservice.sys.domain.dto.response;

import lombok.Builder;

import java.math.BigDecimal;
@Builder
public class OrderItemResponseDTO {
    Integer id;
    int orderId;
    int menuItemId;
    int quantity;
    BigDecimal unitPrice;
}
