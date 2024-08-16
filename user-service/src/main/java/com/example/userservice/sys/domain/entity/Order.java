package com.example.userservice.sys.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Builder.Default
    String userId = null;

    @Builder.Default
    int restaurantId = 0;

    @Enumerated(EnumType.STRING)
    OrderStatus status;

    @Column(name = "created_at")
    @Builder.Default
    LocalDateTime createAt = LocalDateTime.now();

    BigDecimal totalAmount;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    List<OrderItem> orderItems;
}
