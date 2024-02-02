package com.barbershop.domain.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.domain.address.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
    
}

