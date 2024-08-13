package com.example.userservice.sys.service.impl;

import com.example.userservice.sys.domain.dto.request.OrderRequestDTO;
import com.example.userservice.sys.domain.dto.response.OrderResponseDTO;
import com.example.userservice.sys.repository.OrderRepository;
import com.example.userservice.sys.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor // auto inject to "final" variable
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;

    @Override
    public ResponseEntity<List<OrderResponseDTO>> getAllOrdersForUser() {
        return null;
    }

    @Override
    public ResponseEntity<BigDecimal> getTotalAmountSpentByUser(Integer userId) {
        return null;
    }

    @Override
    public ResponseEntity<List<OrderResponseDTO>> getOrderByStatus(Integer userId, String status) {
        return null;
    }

    @Override
    public ResponseEntity<OrderResponseDTO> makeOrder(Integer userId, String email, OrderRequestDTO request) {
        return null;
    }
}
