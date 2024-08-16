package com.example.userservice.sys.domain.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponseDTO {
    Integer id;
    String userId;
    int restaurantId;
    String status;
    BigDecimal totalAmount;

    LocalDateTime createAt;
    List<OrderItemResponseDTO> orderItems;
}
