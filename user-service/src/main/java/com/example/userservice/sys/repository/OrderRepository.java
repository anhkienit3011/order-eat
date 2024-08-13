package com.example.userservice.sys.repository;

import com.example.userservice.sys.domain.entity.Order;
import com.example.userservice.sys.domain.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Query("""
        SELECT o FROM Order o
        JOIN FETCH o.orderItems
        WHERE o.userId = :userId
    """)
     List<Order> findByUserId(@Param("userId") Integer userId);
     List<Order> findByRestaurantIdAndUserId(Integer restaurantId,Integer userId);
     List<Order> findByStatus(OrderStatus status);
     List<Order> findByUserIdAndStatus(Integer userId,OrderStatus status);

    @Query("""
        SELECT o FROM Order o
        JOIN FETCH o.orderItems
        WHERE o.id = :orderId AND o.userId = :userId
    """)
     Order findOrderWithOrderItemsByIdAndUserId(Integer orderId,Integer userId);

    @Query("""
        SELECT SUM(o.totalAmount) FROM Order o
        Where o.userId = :userId
    """)
    BigDecimal getTotalAmountSpentByUser(Integer userId);
}
