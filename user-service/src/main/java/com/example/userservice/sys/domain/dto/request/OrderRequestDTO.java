package com.example.userservice.sys.domain.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequestDTO {
    Integer restaurantId;
    String status;
    BigDecimal totalAmount;
    List<OrderItemRequestDTO> orderItems;
}
