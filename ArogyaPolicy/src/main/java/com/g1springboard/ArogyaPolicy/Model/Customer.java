package com.g1springboard.ArogyaPolicy.Model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;
    private String email;
    private String password;
    
    private String address;
    private LocalDate registrationDate;
    private boolean isActive;
   
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role = Role.CUSTOMER;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany(mappedBy = "customer")
    private List<Policy> policies;

    @OneToMany(mappedBy = "customer")
    private List<Claim> claims;

    @OneToMany(mappedBy = "customer")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "customer")
    private List<Transaction> transactions;
    
}
