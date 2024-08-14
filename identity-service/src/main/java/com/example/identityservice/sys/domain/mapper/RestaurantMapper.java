package com.example.identityservice.sys.domain.mapper;

import com.example.identityservice.sys.domain.dto.request.RestaurantCreationRequest;
import com.example.identityservice.sys.domain.dto.request.RestaurantRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    RestaurantCreationRequest toRestaurantCreationRequest(RestaurantRequest request);
}
