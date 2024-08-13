package com.example.userservice.sys.repository;

import com.example.userservice.sys.domain.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {
     List<OrderItem> findByOrderId(Integer orderId);
     List<OrderItem> findByMenuItemId(Integer menuItemId);
     List<OrderItem> findByOrderUserId(Integer userId);
     List<OrderItem>findByOrderRestaurantId(Integer restaurantId);

    @Query("""
        SELECT i FROM OrderItem i
        JOIN i.order o
        WHERE o.userId = :userId
        AND
        o.createdAt BETWEEN :startDateTime AND :endDateTime
    """)
     List<OrderItem>findUserOrderCreatedBetween(
            @Param("userId")Integer userId,
            @Param("startDateTime")LocalDateTime startDateTime,
            @Param("endDateTime") LocalDateTime endDateTime
    );
}
