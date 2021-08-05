package com.prototype.bankaccounttransactionapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("accountName")
    private String accountName;

    @Column(name = "transactions")
    @OneToMany(mappedBy="account", fetch = FetchType.LAZY, orphanRemoval = true)
    private List <Transaction> transactions;

    @Column(name = "initial_credit")
    private double initialCredit;

    @Column(name = "customer_id")
    @JsonProperty("customerId")
    private Long customerId = null;

    public Account(Long customerId, String accountName, List transactions, double initialCredit) {
        this.customerId = customerId;
        this.accountName = accountName;
        this.transactions = transactions;
        this.initialCredit = initialCredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.initialCredit, initialCredit) == 0 && Objects.equals(accountId, account.accountId) && Objects.equals(accountName, account.accountName) && Objects.equals(transactions, account.transactions) && Objects.equals(customerId, account.customerId);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", transactions=" + transactions +
                ", initialCredit=" + initialCredit +
                ", customerId=" + customerId +
                '}';
    }
}
