package com.example.userservice.sys.domain.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemRequestDTO {
    Integer menuItemId;
    int quantity;
    BigDecimal unitPrice;
}
