package com.example.userservice.sys.util;

import com.example.userservice.sys.domain.dto.MenuItem;
import com.example.userservice.sys.domain.dto.Restaurant;
import com.example.userservice.sys.domain.dto.response.OrderItemResponseDTO;
import com.example.userservice.sys.domain.dto.response.OrderItemResponseWithMenuItemDTO;
import com.example.userservice.sys.domain.dto.response.OrderResponseDTO;
import com.example.userservice.sys.domain.dto.response.OrderResponseWithRestaurantDTO;
import com.example.userservice.sys.domain.entity.Order;
import com.example.userservice.sys.domain.entity.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResponseMapper {
    OrderItemResponseDTO orderItemToResponseDTO(OrderItem orderItem){
        return OrderItemResponseDTO.builder()
                .id(orderItem.getId())
                .orderId(orderItem.getOrder().getId())
                .menuItemId(orderItem.getMenuItemId())
                .quantity(orderItem.getQuantity())
                .unitPrice(orderItem.getUnitPrice())
                .build();
    }
    OrderResponseDTO orderToResponseDTO(Order order){
        return OrderResponseDTO.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .restaurantId(order.getRestaurantId())
                .status(order.getStatus().name())
                .totalAmount(order.getTotalAmount())
                .createAt(order.getCreateAt())
                .orderItems(orderItemResponseDTOtoList(order.getOrderItems()))
                .build();
    }

    List<OrderResponseDTO > orderResponseDTOtoList(List<Order>orders){
        return orders.stream().map(this::orderToResponseDTO).collect(Collectors.toList());
    }
    List<OrderItemResponseDTO> orderItemResponseDTOtoList(List<OrderItem> orderItems){
        return orderItems.stream().map(this::orderItemToResponseDTO).collect(Collectors.toList());
    }
    OrderItemResponseWithMenuItemDTO toOrderItemResponseWithMenuItem(OrderItem orderItem,MenuItem menuItem){
        return OrderItemResponseWithMenuItemDTO.builder()
                .id(orderItem.getId())
                .orderId(orderItem.getOrder().getId())
                .menuItem(menuItem)
                .quantity(orderItem.getQuantity())
                .unitPrice(orderItem.getUnitPrice())
                .build();
    }
//    List<OrderItemResponseWithMenuItemDTO>toOrderItemResponseWithMenuItemList(List<OrderItem> orderItems,List<MenuItem>menuItems){
//        return orderItems.stream().map(orderItem ->
//                menuItems.stream().findFirst(menuItem -> menuItem.))
//    }
    OrderResponseWithRestaurantDTO toOrderResponseWithRestaurants(Order order, Restaurant restaurant,
                                                                  List<OrderItem> orderItems, List<MenuItem> menuItems){
        return OrderResponseWithRestaurantDTO.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .restaurant(restaurant)
                .status(order.getStatus().name())
                .totalAmount(order.getTotalAmount())
                .createAt(order.getCreateAt())
                .orderItems(orderItemResponseDTOtoList(orderItems))
                .build();
    }
}
