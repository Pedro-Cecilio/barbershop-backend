package com.barbershop.domain.user;

import java.util.UUID;

import com.barbershop.domain.address.Address;
import com.barbershop.domain.user.dto.CreateUserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    public User(CreateUserDTO createUserDTO) {
        this.address = new Address(createUserDTO.address());
        this.name = createUserDTO.name();
        this.lastname = createUserDTO.lastname();
        this.email = createUserDTO.email();
        this.password = createUserDTO.password();
        this.isProfessional = createUserDTO.isProfessional();
    }

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "isProfessional", nullable = false)
    private Boolean isProfessional;
    
}
