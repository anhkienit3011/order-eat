package com.example.identityservice.sys.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.identityservice.sys.domain.dto.request.UserCreationRequest;
import com.example.identityservice.sys.domain.dto.request.UserUpdateRequest;
import com.example.identityservice.sys.domain.dto.response.UserResponse;
import com.example.identityservice.sys.domain.entity.User;

@Mapper(componentModel = "spring") // to use in spring (DI)
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
