package com.barbershop.domain.barbershopUsers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.domain.barbershopUsers.BarbershopUsers;

public interface BarbershopUsersRepository extends JpaRepository<BarbershopUsers, Long> {
    
}
