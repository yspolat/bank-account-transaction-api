package com.prototype.bankaccounttransactionapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    private @Id @GeneratedValue Long accountId;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "transactions")
    @OneToMany(mappedBy="account", fetch = FetchType.LAZY, orphanRemoval = true)
    private List <Transaction> transactions;

    @Column(name = "initial_credit")
    private double initialCredit;

    @ManyToOne
    @JoinColumn(name="customer_id")
    @JsonBackReference
    private Customer customer;

    public Account(Customer customer, String accountName, List transactions, double initialCredit) {
        this.customer = customer;
        this.accountName = accountName;
        this.transactions = transactions;
        this.initialCredit = initialCredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.initialCredit, initialCredit) == 0 && Objects.equals(accountId, account.accountId) && Objects.equals(accountName, account.accountName) && Objects.equals(transactions, account.transactions) && Objects.equals(customer, account.customer);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", transactions=" + transactions +
                ", initialCredit=" + initialCredit +
                ", customer=" + customer +
                '}';
    }
}
