package com.prototype.bankaccounttransactionapi.service;

import com.prototype.bankaccounttransactionapi.model.Transaction;

public interface TransactionService {

    Transaction createTransaction(Transaction transaction) throws Exception;
}
