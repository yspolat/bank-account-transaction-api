package com.prototype.bankaccounttransactionapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    private @Id @GeneratedValue Long id;
    private String transactionId;
    private Date transactionDate;
    private String transactionStatus;
    private Double amount;
    private String action;

    public Transaction(String transactionId, Date transactionDate, String transactionStatus, Double amount, String action) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionStatus = transactionStatus;
        this.amount = amount;
        this.action = action;
    }
}
