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
public class Account {
    private @Id @GeneratedValue Long accountId;
    private String accountName;
    @OneToMany(targetEntity= Transaction.class)
    private List transactions;

    public Account(String accountName, List transactions) {
        this.accountName = accountName;
        this.transactions = transactions;
    }
}
