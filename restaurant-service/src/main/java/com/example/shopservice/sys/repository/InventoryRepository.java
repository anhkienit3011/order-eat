package com.example.shopservice.sys.repository;

import com.example.shopservice.sys.domain.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
}
