package com.g1springboard.ArogyaPolicy.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Admin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String name;
    private String email;
    private String password;

    private Role role = Role.ADMIN;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Customer> customer;
    
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Scheme> schemes;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Policy> policies;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Claim> claims;

   


    
}
