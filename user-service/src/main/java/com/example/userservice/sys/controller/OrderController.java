package com.example.userservice.sys.controller;

import com.example.userservice.sys.domain.dto.request.OrderRequestDTO;
import com.example.userservice.sys.domain.dto.response.OrderResponseDTO;
import com.example.userservice.sys.domain.dto.response.OrderResponseWithRestaurantDTO;
import com.example.userservice.sys.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RequestMapping("/api/v1/orders")
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class OrderController {
    OrderService orderService;
    @GetMapping
    ResponseEntity<List<OrderResponseDTO>>getAllOrders(){

        return orderService.getAllOrdersForUser();
    }
    @GetMapping("/totalAmount")
    public ResponseEntity<BigDecimal> getTotalAmountSpent() {
        return orderService.getTotalAmountSpentByUser();
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> makeOrder(@RequestBody OrderRequestDTO order) {

        return orderService.makeOrder(order);
    }

    @GetMapping("/full")
    public ResponseEntity<List<OrderResponseWithRestaurantDTO>> getOrdersWithRestaurantsAndMenuItems() {
        return orderService.getOrdersWithRestaurantsAndMenuItems().block();
    }
}
