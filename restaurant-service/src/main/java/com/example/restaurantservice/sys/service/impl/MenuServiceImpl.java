package com.example.restaurantservice.sys.service.impl;

import com.example.restaurantservice.exception.AppException;
import com.example.restaurantservice.exception.ErrorCode;
import com.example.restaurantservice.sys.domain.dto.MenuItemProjection;
import com.example.restaurantservice.sys.domain.dto.request.MenuItemRequestDto;
import com.example.restaurantservice.sys.domain.dto.request.MenuRequestDto;
import com.example.restaurantservice.sys.domain.dto.response.MenuResponseDto;
import com.example.restaurantservice.sys.domain.entity.Menu;
import com.example.restaurantservice.sys.domain.entity.MenuItem;
import com.example.restaurantservice.sys.domain.mapper.MenuMapper;
import com.example.restaurantservice.sys.repository.MenuItemRepository;
import com.example.restaurantservice.sys.repository.MenuRepository;
import com.example.restaurantservice.sys.repository.RestaurantRepository;
import com.example.restaurantservice.sys.service.MenuService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor // auto inject to "final" variable
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MenuServiceImpl implements MenuService {
    MenuRepository menuRepository;
    MenuMapper menuMapper;
    RestaurantRepository restaurantRepository;
    MenuItemRepository menuItemRepository;
    @Override
    public ResponseEntity<List<MenuResponseDto>> getAllMenus() {
        val menus = menuRepository.findAll();
        val menuResponseToList = menuMapper.toListMenuResponse(menus);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(menuResponseToList);
    }

    @Override
    public ResponseEntity<List<MenuResponseDto>> getAllMenusWithItems() {
        val menus = menuRepository.findAllWithMenuItems();
        val menuResponseToList = menuMapper.toListMenuResponse(menus);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(menuResponseToList);
    }

    @Override
    public ResponseEntity<List<MenuResponseDto>> getMenusByRestaurant(Integer restaurantId) {
        var restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(()-> new AppException(ErrorCode.RESTAURANT_NOT_FOUND));
        var menus = menuRepository.findAllByRestaurant(restaurant);
        var response = menuMapper.toListMenuResponse(menus);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);

    }

    @Override
    public ResponseEntity<HttpStatus> addMenu(MenuRequestDto request) {
        var restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(()-> new AppException(ErrorCode.RESTAURANT_NOT_FOUND));

        var menu = menuMapper.toMenu(request);
         menu.setRestaurant(restaurant) ;
        menuRepository.save(menu);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @Override
    @Transactional
    public ResponseEntity<List<MenuItemProjection>> getMenuItemsByIds(List<Integer> ids) {
        var menuItems = menuItemRepository.findByIds(ids);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(menuItems);
    }

    @Override
    public ResponseEntity<HttpStatus> addMenuItems(MenuItemRequestDto request) {
        var menu = menuRepository.findById(request.getMenuId())
                .orElseThrow(()-> new AppException(ErrorCode.RESTAURANT_NOT_FOUND));

        var menuItem = MenuItem.builder()
                .menu(menu)
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();

        menuItemRepository.save(menuItem);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }
}
