package com.example.identityservice.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.identityservice.sys.domain.entity.InvalidatedToken;

public interface InvalidateRepository extends JpaRepository<InvalidatedToken, String> {}
