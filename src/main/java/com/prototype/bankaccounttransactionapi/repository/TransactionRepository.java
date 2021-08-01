package com.prototype.bankaccounttransactionapi.repository;

import com.prototype.bankaccounttransactionapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("transactionRepository")
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
