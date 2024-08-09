package com.example.restaurantservice.sys.service.impl;

import com.example.restaurantservice.sys.domain.dto.RestaurantProjection;
import com.example.restaurantservice.sys.domain.dto.request.RestaurantRequestDto;
import com.example.restaurantservice.sys.domain.dto.response.RestaurantResponseDto;
import com.example.restaurantservice.sys.domain.mapper.MenuMapper;
import com.example.restaurantservice.sys.domain.mapper.RestaurantMapper;
import com.example.restaurantservice.sys.repository.MenuRepository;
import com.example.restaurantservice.sys.repository.RestaurantRepository;
import com.example.restaurantservice.sys.service.RestaurantService;
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
public class RestaurantServiceImpl implements RestaurantService {
    RestaurantRepository restaurantRepository;
    MenuRepository menuRepository;
    MenuMapper menuMapper;
    RestaurantMapper restaurantMapper;
    @Override
    public ResponseEntity<List<RestaurantResponseDto>> getRestaurants() {
        var restaurants = restaurantRepository.findAll();
        var restaurantResponseToList = restaurantMapper.toListRestaurantResponse(restaurants);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(restaurantResponseToList);
    }

    @Override
    public ResponseEntity<List<RestaurantResponseDto>> getRestaurantsWithMenus() {
        return null;
    }

    @Override
    public ResponseEntity<RestaurantResponseDto> findRestaurantByName(String name) {
        return null;
    }

    @Override
    public ResponseEntity<RestaurantResponseDto> findByPhone(String phone) {
        return null;
    }

    @Override
    public ResponseEntity<List<RestaurantResponseDto>> findByAddress(String address) {
        return null;
    }

    @Override
    public ResponseEntity<HttpStatus> addRestaurant(RestaurantRequestDto request) {

       var restaurant = restaurantMapper.toRestaurant(request);
       restaurantRepository.save(restaurant);
       return ResponseEntity
               .status(HttpStatus.OK)
               .build();

    }

    @Override
    @Transactional
    public ResponseEntity<List<RestaurantProjection>> findRestaurantsByIds(List<Integer> ids) {

        val restaurants = restaurantRepository.findByIds(ids);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(restaurants);
    }
}
