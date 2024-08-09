package com.example.restaurantservice.sys.service;

import com.example.restaurantservice.sys.domain.dto.MenuItemProjection;
import com.example.restaurantservice.sys.domain.dto.request.MenuItemRequestDto;
import com.example.restaurantservice.sys.domain.dto.request.MenuRequestDto;
import com.example.restaurantservice.sys.domain.dto.response.MenuResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MenuService {
    ResponseEntity<List<MenuResponseDto>> getAllMenus();
    ResponseEntity<List<MenuResponseDto>> getAllMenusWithItems();
    ResponseEntity<List<MenuResponseDto>> getMenusByRestaurant(Integer restaurantId);
    ResponseEntity<HttpStatus> addMenu(MenuRequestDto request);
    ResponseEntity<List<MenuItemProjection>> getMenuItemsByIds(List<Integer> ids);
    ResponseEntity<HttpStatus> addMenuItems(MenuItemRequestDto request);


}
