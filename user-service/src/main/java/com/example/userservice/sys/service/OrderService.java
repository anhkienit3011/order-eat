package com.example.userservice.sys.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.userservice.sys.domain.dto.response.OrderResponseWithRestaurantDTO;
import org.springframework.http.ResponseEntity;

import com.example.userservice.sys.domain.dto.request.OrderRequestDTO;
import com.example.userservice.sys.domain.dto.response.OrderResponseDTO;
import reactor.core.publisher.Mono;

public interface OrderService {
    ResponseEntity<List<OrderResponseDTO>> getAllOrdersForUser();

    ResponseEntity<BigDecimal> getTotalAmountSpentByUser();

    ResponseEntity<List<OrderResponseDTO>> getOrderByStatus( String status);

    ResponseEntity<OrderResponseDTO> makeOrder( OrderRequestDTO request);
    Mono<ResponseEntity<List<OrderResponseWithRestaurantDTO>>> getOrdersWithRestaurantsAndMenuItems();
}
