package com.g1springboard.ArogyaPolicy.Model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Policy {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyId;

    private String name;
    private String description;
    
    private LocalDate startDate;

    private Double totalPremiumAmount;
    private Double maturityAmount;
    private int numberOfYears;
    
    @Enumerated(EnumType.STRING)
    private PolicyStatus policyStatus = PolicyStatus.ACTIVE;
    
    @Enumerated(EnumType.STRING)
    private String annuityTerm;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "scheme_id")
    private Scheme scheme;

    @OneToMany(mappedBy = "policy")
    private List<Claim> claims;

    @OneToMany(mappedBy = "policy")
    private List<Transaction> transactions;
    

}
