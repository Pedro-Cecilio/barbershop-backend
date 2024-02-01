package com.barbershop.domain.address.dto;

public record CreateAddressDTO(
    String cep,
    String street,
    String number,
    String district,
    String state,
    String country
) {
    
}
