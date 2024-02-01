package com.barbershop.domain.address;

import com.barbershop.domain.address.dto.CreateAddressDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {

    public Address(CreateAddressDTO createAddressDTO){
        this.cep = createAddressDTO.cep();
        this.street = createAddressDTO.street();
        this.number = createAddressDTO.number();
        this.district = createAddressDTO.district();
        this.state = createAddressDTO.state();
        this.country = createAddressDTO.country();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "country", nullable = false)
    private String country;
}
