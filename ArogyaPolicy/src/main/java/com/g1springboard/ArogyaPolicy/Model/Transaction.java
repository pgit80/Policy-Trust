package com.g1springboard.ArogyaPolicy.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    
    private LocalDate transactionDate;
    private Double amount;
    private String transactionType;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

}
