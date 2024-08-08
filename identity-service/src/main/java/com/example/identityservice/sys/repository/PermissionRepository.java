package com.example.identityservice.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.identityservice.sys.domain.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, String> {}
