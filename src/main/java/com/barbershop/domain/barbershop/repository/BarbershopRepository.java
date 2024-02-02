package com.barbershop.domain.barbershop.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.domain.barbershop.Barbershop;

public interface BarbershopRepository extends JpaRepository<Barbershop, UUID> {
    
}
