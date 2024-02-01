package com.barbershop.domain.user.dto;

import com.barbershop.domain.address.dto.CreateAddressDTO;

public record CreateUserDTO(
    CreateAddressDTO address,
    String name,
    String lastname,
    String email,
    String password,
    boolean isProfessional
) {
    
}
