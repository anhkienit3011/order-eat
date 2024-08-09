package com.example.restaurantservice.sys.controller;

import com.example.restaurantservice.sys.domain.dto.request.MenuItemRequestDto;
import com.example.restaurantservice.sys.domain.dto.request.MenuRequestDto;
import com.example.restaurantservice.sys.domain.dto.response.MenuResponseDto;
import com.example.restaurantservice.sys.service.MenuService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class MenuController {
    MenuService menuService;

    @GetMapping
    ResponseEntity<List<MenuResponseDto>> getAllMenus(){
        return menuService.getAllMenus();
    }

    @PostMapping("/menuItem")
    ResponseEntity<HttpStatus> addMenuItems(@RequestBody MenuItemRequestDto request){
        return menuService.addMenuItems(request);
    }

    @PostMapping
    ResponseEntity<HttpStatus> addMenu(@RequestBody MenuRequestDto request){
        return menuService.addMenu(request);
    }
}
