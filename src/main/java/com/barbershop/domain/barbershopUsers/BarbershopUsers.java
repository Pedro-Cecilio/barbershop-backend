package com.barbershop.domain.barbershopUsers;

import com.barbershop.domain.barbershop.Barbershop;
import com.barbershop.domain.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "barbershop_users")
@Getter
@Setter
public class BarbershopUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "barbershop_id")
    private Barbershop barbershop;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "isOwner", nullable = false)
    private Boolean isOwner;  

    @Column(name = "isProfessional", nullable = false)
    private Boolean isProfessional;
    
}
