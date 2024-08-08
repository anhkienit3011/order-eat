package com.example.shopservice.sys.repository;

import com.example.shopservice.sys.domain.entity.Inventory;
import com.example.shopservice.sys.domain.entity.Menu;
import com.example.shopservice.sys.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu,Integer> {
    @Query("SELECT m FROM Menu m WHERE m.restaurant = :restaurant")
    List<Menu> findAllByRestaurant(@Param("restaurant") Restaurant restaurant);

    @Query("SELECT DISTINCT m FROM Menu m LEFT JOIN FETCH m.menuItems")
    List<Menu> findAllWithMenuItems();
}
