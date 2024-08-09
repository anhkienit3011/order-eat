package com.example.restaurantservice.sys.repository;

import com.example.restaurantservice.sys.domain.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
}
