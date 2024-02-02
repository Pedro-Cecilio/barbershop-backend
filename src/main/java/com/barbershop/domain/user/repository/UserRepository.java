package com.barbershop.domain.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.domain.user.User;

public interface UserRepository extends JpaRepository<User, UUID>{
    User findByEmail(String email);

}
