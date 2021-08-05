package com.prototype.bankaccounttransactionapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id @GeneratedValue
    private Long transactionId;
    @ManyToOne
    @JoinColumn(name="account_id")
    @JsonBackReference
    private Account account;
    private Long customerID;
    private Date transactionDate;
    private String transactionStatus;
    private Double amount;
    private String action;

    public Transaction(Account account, Long customerID, Date transactionDate, String transactionStatus, Double amount, String action) {
        this.account = account;
        this.customerID = customerID;
        this.transactionDate = transactionDate;
        this.transactionStatus = transactionStatus;
        this.amount = amount;
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(account, that.account) && Objects.equals(customerID, that.customerID) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(transactionStatus, that.transactionStatus) && Objects.equals(amount, that.amount) && Objects.equals(action, that.action);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", account=" + account +
                ", customerID=" + customerID +
                ", transactionDate=" + transactionDate +
                ", transactionStatus='" + transactionStatus + '\'' +
                ", amount=" + amount +
                ", action='" + action + '\'' +
                '}';
    }

    public enum TransactionType {
            PENDING, CLEARED, REJECTED, AUTHORIZED
    }
}