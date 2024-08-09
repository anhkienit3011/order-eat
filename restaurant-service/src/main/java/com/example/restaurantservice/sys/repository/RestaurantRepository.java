package com.example.restaurantservice.sys.repository;

import com.example.restaurantservice.sys.domain.dto.RestaurantProjection;
import com.example.restaurantservice.sys.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
    @Query("SELECT DISTINCT r FROM Restaurant r LEFT JOIN FETCH r.menus")
    List<Restaurant> findAllWithMenus();

    @Query("""
        SELECT NEW com.example.restaurantservice.sys.domain.dto.RestaurantProjection(r.id, r.name, r.description, r.address, r.phone, r.email)
        FROM Restaurant r
        WHERE r.id IN :ids
    """)
    List<RestaurantProjection> findByIds (@Param("ids") List<Integer> ids);
}
