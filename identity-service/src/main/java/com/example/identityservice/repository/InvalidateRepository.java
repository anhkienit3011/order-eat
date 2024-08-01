package com.example.identityservice.repository;

import com.example.identityservice.entity.InvalidatedToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvalidateRepository extends JpaRepository<InvalidatedToken,String> {
}
