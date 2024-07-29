package com.example.identityservice.mapper;

import com.example.identityservice.dto.request.PermissionRequest;
import com.example.identityservice.dto.response.PermissionResponse;
import com.example.identityservice.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // to use in spring (DI)
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
