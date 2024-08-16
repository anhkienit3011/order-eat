package com.example.userservice.sys.util;

import com.example.userservice.sys.domain.dto.request.OrderItemRequestDTO;
import com.example.userservice.sys.domain.dto.request.OrderRequestDTO;
import com.example.userservice.sys.domain.entity.Order;
import com.example.userservice.sys.domain.entity.OrderItem;
import com.example.userservice.sys.domain.entity.OrderStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestMapper {

    public OrderItem requestToOrderItem(OrderItemRequestDTO request, Order order) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setMenuItemId(request.getMenuItemId());
        orderItem.setQuantity(request.getQuantity());
        orderItem.setUnitPrice(request.getUnitPrice());
        return orderItem;
    }

    public Order requestToOrder(OrderRequestDTO request) {
        Order order = new Order();
        order.setRestaurantId(request.getRestaurantId());
        order.setStatus(OrderStatus.valueOf(request.getStatus()));
        order.setTotalAmount(request.getTotalAmount());
        order.setCreateAt(LocalDateTime.now());

        List<OrderItem> orderItems = orderItemRequestToOrderItemList(request.getOrderItems(), order);
        order.getOrderItems().addAll(orderItems);

        return order;
    }

    public List<OrderItem> orderItemRequestToOrderItemList(List<OrderItemRequestDTO> items, Order order) {
        return items.stream()
                .map(item -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setOrder(order);
                    orderItem.setMenuItemId(item.getMenuItemId());
                    orderItem.setQuantity(item.getQuantity());
                    orderItem.setUnitPrice(item.getUnitPrice());
                    return orderItem;
                })
                .collect(Collectors.toList());
    }
}
