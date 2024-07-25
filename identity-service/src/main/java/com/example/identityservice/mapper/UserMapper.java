package com.example.identityservice.mapper;

import com.example.identityservice.dto.request.UserCreationRequest;
import com.example.identityservice.dto.request.UserUpdateRequest;
import com.example.identityservice.dto.response.UserResponse;
import com.example.identityservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring") // to use in spring (DI)
public interface UserMapper   {
    User toUser(UserCreationRequest request);
    UserResponse toUserReponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
