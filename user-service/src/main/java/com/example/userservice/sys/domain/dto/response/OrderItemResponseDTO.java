package com.example.userservice.sys.domain.dto.response;

import java.math.BigDecimal;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemResponseDTO {
    Integer id;
    int orderId;
    int menuItemId;
    int quantity;
    BigDecimal unitPrice;
}
