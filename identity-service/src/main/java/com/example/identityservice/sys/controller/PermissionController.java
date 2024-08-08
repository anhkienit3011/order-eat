package com.example.identityservice.sys.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.identityservice.sys.domain.dto.request.PermissionRequest;
import com.example.identityservice.sys.domain.dto.response.ApiResponse;
import com.example.identityservice.sys.domain.dto.response.PermissionResponse;
import com.example.identityservice.sys.service.PermissionService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PermissionController {
    PermissionService permissionService;

    @PostMapping
    ApiResponse<PermissionResponse> create(@RequestBody PermissionRequest request) {
        return ApiResponse.<PermissionResponse>builder()
                .result(permissionService.create(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<PermissionResponse>> getAll() {
        return ApiResponse.<List<PermissionResponse>>builder()
                .result(permissionService.getAll())
                .build();
    }

    @DeleteMapping("/{permissionId}")
    ApiResponse<String> deletePermission(@PathVariable String permissionId) {
        permissionService.delete(permissionId);
        return ApiResponse.<String>builder()
                .result("Permission has been deleted")
                .build();
    }
}
