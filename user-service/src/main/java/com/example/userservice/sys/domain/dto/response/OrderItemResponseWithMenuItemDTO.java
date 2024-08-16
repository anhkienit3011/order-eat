package com.example.userservice.sys.domain.dto.response;

import java.math.BigDecimal;

import com.example.userservice.sys.domain.dto.MenuItem;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemResponseWithMenuItemDTO {
    Integer id;
    int orderId;
    MenuItem menuItem;
    int quantity;
    BigDecimal unitPrice;
}
