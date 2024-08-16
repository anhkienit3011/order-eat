package com.example.userservice.sys.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.userservice.sys.domain.entity.Order;
import com.example.userservice.sys.domain.entity.OrderStatus;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	@Query("""
        SELECT o FROM Order o
        JOIN FETCH o.orderItems
        WHERE o.userId = :userId
    """)
    List<Order> findByUserId(@Param("userId") String userId);

    List<Order> findByRestaurantIdAndUserId(Integer restaurantId, String userId);

    List<Order> findByStatus(OrderStatus status);

    List<Order> findByUserIdAndStatus(String userId, OrderStatus status);

    @Query("""
		SELECT o FROM Order o
		JOIN FETCH o.orderItems
		WHERE o.id = :orderId AND o.userId = :userId
	""")
    Order findOrderWithOrderItemsByIdAndUserId(Integer orderId, String userId);

    @Query("""
		SELECT SUM(o.totalAmount) FROM Order o
		Where o.userId = :userId
	""")
    BigDecimal getTotalAmountSpentByUser(String userId);
}
