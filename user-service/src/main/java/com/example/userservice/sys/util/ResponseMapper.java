package com.example.userservice.sys.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResponseMapper {

    public OrderItemResponseDTO orderItemToResponseDTO(OrderItem orderItem) {
        return OrderItemResponseDTO.builder()
                .id(orderItem.getId())
                .orderId(orderItem.getOrder().getId())
                .menuItemId(orderItem.getMenuItemId())
                .quantity(orderItem.getQuantity())
                .unitPrice(orderItem.getUnitPrice())
                .build();
    }

    public OrderResponseDTO orderToResponseDTO(Order order) {
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

    public List<OrderItemResponseDTO> orderItemResponseDTOtoList(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(this::orderItemToResponseDTO)
                .collect(Collectors.toList());
    }

    public List<OrderResponseDTO> orderResponseDTOtoList(List<Order> orders) {
        return orders.stream()
                .map(this::orderToResponseDTO)
                .collect(Collectors.toList());
    }

    public OrderItemResponseWithMenuItemDTO toOrderItemResponseWithMenuItem(OrderItem orderItem, MenuItem menuItem) {
        return OrderItemResponseWithMenuItemDTO.builder()
                .id(orderItem.getId())
                .orderId(orderItem.getOrder().getId())
                .menuItem(menuItem)
                .quantity(orderItem.getQuantity())
                .unitPrice(orderItem.getUnitPrice())
                .build();
    }

    public List<OrderItemResponseWithMenuItemDTO> toOrderItemResponseWithMenuItemList(List<OrderItem> orderItems, List<MenuItem> menuItems) {
        return orderItems.stream()
                .map(orderItem -> menuItems.stream()
                        .filter(menuItem -> menuItem.getId().equals(orderItem.getMenuItemId()))
                        .findFirst()
                        .map(menuItem -> toOrderItemResponseWithMenuItem(orderItem, menuItem))
                        .orElse(null))
                .filter(item -> item != null)
                .collect(Collectors.toList());
    }

    public OrderResponseWithRestaurantDTO toOrderResponseWithRestaurants(Order order, Restaurant restaurant, List<OrderItem> orderItems, List<MenuItem> menuItems) {
        return OrderResponseWithRestaurantDTO.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .restaurant(restaurant)
                .status(order.getStatus().name())
                .totalAmount(order.getTotalAmount())
                .createAt(order.getCreateAt())
                .orderItems(toOrderItemResponseWithMenuItemList(orderItems, menuItems))
                .build();
    }

    public List<OrderResponseWithRestaurantDTO> toOrderResponseWithRestaurantsList(List<Order> orders, List<Restaurant> restaurants, List<OrderItem> allOrderItems, List<MenuItem> allMenuItems) {
        return orders.stream()
                .map(order -> {
                    Restaurant restaurant = restaurants.stream()
                            .filter(r -> r.getId().equals(order.getRestaurantId()))
                            .findFirst()
                            .orElse(new Restaurant(0, "", "", "", "", ""));
                    List<OrderItem> items = allOrderItems.stream()
                            .filter(item -> item.getOrder().getId().equals(order.getId()))
                            .collect(Collectors.toList());
                    List<MenuItem> menuItemList = allMenuItems.stream()
                            .filter(menuItem -> menuItem.getMenuId()==order.getRestaurantId())
                            .collect(Collectors.toList());
                    return new OrderResponseWithRestaurantDTO(
                            order.getId(),
                            order.getUserId(),
                            restaurant,
                            order.getStatus().name(),
                            order.getTotalAmount(),
                            order.getCreateAt(),
                            toOrderItemResponseWithMenuItemList(items, menuItemList)
                    );
                })
                .collect(Collectors.toList());
    }
}