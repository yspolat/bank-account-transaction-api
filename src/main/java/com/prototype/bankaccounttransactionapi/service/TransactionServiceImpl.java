package com.prototype.bankaccounttransactionapi.service;

import com.prototype.bankaccounttransactionapi.model.Transaction;
import com.prototype.bankaccounttransactionapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction(Transaction transaction) throws Exception {
        transactionRepository.save(transaction);
        return transaction;
    }
}
