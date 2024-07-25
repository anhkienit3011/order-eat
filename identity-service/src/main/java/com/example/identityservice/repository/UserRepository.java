package com.example.identityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.example.identityservice.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
