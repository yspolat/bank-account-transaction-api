package com.prototype.bankaccounttransactionapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    private @Id @GeneratedValue Long customerId;
    private String name;
    private String surname;
    private double balance;
    private double initialCredit;
    @OneToMany(targetEntity= Account.class)
    private List accounts;

    public Customer(String name, String surname, double balance, double initialCredit, List accounts) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.initialCredit = initialCredit;
        this.accounts = accounts;
    }
}
