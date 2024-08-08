package com.example.identityservice.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.identityservice.sys.domain.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {}
