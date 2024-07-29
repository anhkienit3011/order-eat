package com.example.identityservice.service;

import com.example.identityservice.dto.request.PermissionRequest;
import com.example.identityservice.dto.response.PermissionResponse;
import com.example.identityservice.entity.Permision;
import com.example.identityservice.mapper.PermissionMapper;
import com.example.identityservice.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;
    public PermissionResponse create(PermissionRequest request){
        Permision permision = permissionMapper.toPermission(request);
        permision = permissionRepository.save(permision);
        return permissionMapper.toPermissionResponse(permision);
    }

    public List<PermissionResponse>getAll(){
        var permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    public void deletePermision (String permissionName){
        permissionRepository.deleteById(permissionName);
    }
}
