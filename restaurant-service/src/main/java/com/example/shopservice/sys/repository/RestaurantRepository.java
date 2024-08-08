package com.example.shopservice.sys.repository;

import com.example.shopservice.sys.domain.entity.Inventory;
import com.example.shopservice.sys.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
}
