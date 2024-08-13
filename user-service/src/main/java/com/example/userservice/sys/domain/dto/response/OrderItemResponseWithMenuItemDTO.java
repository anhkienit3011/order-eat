package com.example.userservice.sys.domain.dto.response;

import com.example.userservice.sys.domain.dto.MenuItem;
import lombok.Builder;

import java.math.BigDecimal;
@Builder
public class OrderItemResponseWithMenuItemDTO {
    Integer id;
    int orderId;
    MenuItem menuItem;
    int quantity;
    BigDecimal unitPrice;
}
