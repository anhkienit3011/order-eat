package com.example.userservice.sys.domain.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.userservice.sys.domain.dto.Restaurant;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponseWithRestaurantDTO {
    Integer id;
    String userId;
    Restaurant restaurant;
    String status;
    BigDecimal totalAmount;

    LocalDateTime createAt;
    List<OrderItemResponseWithMenuItemDTO> orderItems;
}
