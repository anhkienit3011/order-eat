package com.example.identityservice.sys.repository.httpclient;

import com.example.identityservice.sys.domain.dto.request.RestaurantCreationRequest;
import com.example.identityservice.sys.domain.dto.response.ApiResponse;
import com.example.identityservice.sys.domain.dto.response.RestaurantResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "restaurant-service",url = "http://localhost:8081/restaurant")
public interface RestaurantClient {
    @PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<RestaurantResponseDto> createRestaurant (@RequestBody RestaurantCreationRequest request);

}
