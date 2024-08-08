package com.example.identityservice.sys.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.identityservice.sys.domain.dto.request.RoleRequest;
import com.example.identityservice.sys.domain.dto.response.RoleResponse;
import com.example.identityservice.sys.domain.entity.Role;

@Mapper(componentModel = "spring") // to use in spring (DI)
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
