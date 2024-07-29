package com.example.identityservice.repository;

import com.example.identityservice.entity.Permision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permision,String> {
}
