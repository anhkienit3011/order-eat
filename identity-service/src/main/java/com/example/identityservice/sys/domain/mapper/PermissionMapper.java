package com.example.identityservice.sys.domain.mapper;

import org.mapstruct.Mapper;

import com.example.identityservice.sys.domain.dto.request.PermissionRequest;
import com.example.identityservice.sys.domain.dto.response.PermissionResponse;
import com.example.identityservice.sys.domain.entity.Permission;

@Mapper(componentModel = "spring") // to use in spring (DI)
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
