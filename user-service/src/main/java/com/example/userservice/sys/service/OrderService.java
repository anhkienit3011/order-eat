package com.example.userservice.sys.service;

import com.example.userservice.sys.domain.dto.request.OrderRequestDTO;
import com.example.userservice.sys.domain.dto.response.OrderResponseDTO;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    ResponseEntity<List<OrderResponseDTO>> getAllOrdersForUser();
    ResponseEntity<BigDecimal>getTotalAmountSpentByUser(Integer userId);
    ResponseEntity<List<OrderResponseDTO>>getOrderByStatus (Integer userId,String status);
    ResponseEntity<OrderResponseDTO>makeOrder(Integer userId, String email, OrderRequestDTO request);


}
