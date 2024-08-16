package com.example.userservice.sys.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.example.userservice.sys.domain.dto.MenuItem;
import com.example.userservice.sys.domain.dto.Restaurant;
import com.example.userservice.sys.domain.dto.response.OrderResponseWithRestaurantDTO;
import com.example.userservice.sys.domain.entity.Order;
import com.example.userservice.sys.domain.entity.OrderItem;
import com.example.userservice.sys.domain.entity.OrderStatus;
import com.example.userservice.sys.producer.NotificationMessage;
import com.example.userservice.sys.producer.Producer;
import com.example.userservice.sys.util.RequestMapper;
import com.example.userservice.sys.util.ResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.userservice.sys.domain.dto.request.OrderRequestDTO;
import com.example.userservice.sys.domain.dto.response.OrderResponseDTO;
import com.example.userservice.sys.repository.OrderRepository;
import com.example.userservice.sys.service.OrderService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor // auto inject to "final" variable
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderServiceImpl implements OrderService {
     OrderRepository orderRepository;
     ResponseMapper responseMapper;
     RequestMapper requestMapper;
     WebClient.Builder webClient;
     Producer producer;
     private String getUserIdFromJWT(){
         //get userId from token
         var authentication = SecurityContextHolder.getContext().getAuthentication();
         Jwt jwt = ((JwtAuthenticationToken)authentication).getToken();
         log.info("userId :"+ jwt.getClaim("userId"));
         return  jwt.getClaim("userId").toString();
     }
    private String getUserEmailFromJWT(){
        //get userId from token
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwt = ((JwtAuthenticationToken)authentication).getToken();
        log.info("userId :"+ jwt.getClaim("email"));
        return  jwt.getClaim("email").toString();
    }
    @Override
    public ResponseEntity<List<OrderResponseDTO>> getAllOrdersForUser() {

        var userId = getUserIdFromJWT();
        List<Order> orders = orderRepository.findByUserId(userId);
        log.info("orders: " +orders.stream().toList());
        List<OrderResponseDTO> response = responseMapper.orderResponseDTOtoList(orders);
        log.info( "response :" +response.toString());
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
    @Override
    public ResponseEntity<BigDecimal> getTotalAmountSpentByUser() {
        var userId = getUserIdFromJWT();
        BigDecimal amount = orderRepository.getTotalAmountSpentByUser(userId);
        return ResponseEntity.ok(amount);
    }
    @Override
    public ResponseEntity<List<OrderResponseDTO>> getOrderByStatus( String status) {
        var userId = getUserIdFromJWT();
        List<Order> orders = orderRepository.findByUserIdAndStatus(userId, OrderStatus.valueOf(status));
        List<OrderResponseDTO> response = responseMapper.orderResponseDTOtoList(orders);
        return ResponseEntity.ok(response);
    }
    @Override
    public ResponseEntity<OrderResponseDTO> makeOrder( OrderRequestDTO request) {
        var userId = getUserIdFromJWT();
        Order order = requestMapper.requestToOrder(request);
        order.setUserId(userId);

        orderRepository.save(order);
        OrderResponseDTO response = responseMapper.orderToResponseDTO(order);

        NotificationMessage message = NotificationMessage.builder()
                .email(getUserEmailFromJWT())
                .dateOfOrder(response.getCreateAt())
                .build();
        producer.sendMessage(message);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public Mono<ResponseEntity<List<OrderResponseWithRestaurantDTO>>> getOrdersWithRestaurantsAndMenuItems() {
        var userId = getUserIdFromJWT();
        return Mono.fromCallable(() -> orderRepository.findByUserId(userId))
                .flatMap(orders -> {
                    List<Integer> restaurantIds = orders.stream()
                            .map(Order::getRestaurantId)
                            .distinct()
                            .toList();

                    List<Integer> orderIds = orders.stream()
                            .flatMap(order -> order.getOrderItems().stream())
                            .map(OrderItem::getMenuItemId)
                            .distinct()
                            .toList();

                    List<OrderItem> allOrderItems = orders.stream()
                            .flatMap(order -> order.getOrderItems().stream())
                            .collect(Collectors.toList());

                    Mono<List<Restaurant>> restaurantsMono = webClient.build()
                            .get()
                            .uri("lb://RESTAURANT-SERVICE/api/v1/restaurants/byIds?ids={restaurantIds}",
                                    String.join(",", restaurantIds.stream().map(String::valueOf).collect(Collectors.toList())))
                            .retrieve()
                            .bodyToFlux(Restaurant.class)
                            .collectList();

                    Mono<List<MenuItem>> menuItemsMono = webClient.build()
                            .get()
                            .uri("lb://RESTAURANT-SERVICE/api/v1/menus/byIds?ids={orderIds}",
                                    String.join(",", orderIds.stream().map(String::valueOf).collect(Collectors.toList())))
                            .retrieve()
                            .bodyToFlux(MenuItem.class)
                            .collectList();

                    return Mono.zip(restaurantsMono, menuItemsMono)
                            .map(tuple -> {
                                List<Restaurant> restaurants = tuple.getT1();
                                List<MenuItem> menuItems = tuple.getT2();

                                List<OrderResponseWithRestaurantDTO> response = responseMapper.toOrderResponseWithRestaurantsList(
                                        orders, restaurants, allOrderItems, menuItems);

                                return ResponseEntity.ok(response);
                            });
                });
    }

}
