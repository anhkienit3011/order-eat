package com.example.shopservice.sys.repository;

import com.example.shopservice.sys.domain.dto.MenuItemProjection;
import com.example.shopservice.sys.domain.entity.Inventory;
import com.example.shopservice.sys.domain.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem,Integer> {
    @Query("""
        SELECT NEW com.subproblem.restaurantservice.dto.MenuItemProjection(
        m.id, m.menu.id, m.name, m.description, m.price
        )
        FROM MenuItem m
        WHERE m.id IN :ids
        """)
    List<MenuItemProjection> findByIds(@Param("ids") List<Integer> ids);
}
