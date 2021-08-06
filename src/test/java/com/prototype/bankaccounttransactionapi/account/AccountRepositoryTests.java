package com.prototype.bankaccounttransactionapi.account;

import static org.junit.Assert.*;
import com.prototype.bankaccounttransactionapi.model.Account;
import com.prototype.bankaccounttransactionapi.model.Transaction;
import com.prototype.bankaccounttransactionapi.repository.AccountRepository;
import com.prototype.bankaccounttransactionapi.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

@SpringBootTest
public class AccountRepositoryTests {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Test
    void testAccountCreation() throws Exception {
        Account account = new Account(1L,"acc1",null,500);
        Account savedAccount = accountRepository.save(account);
        assertNotNull(savedAccount);
    }

    @Test
    public void testAccountTransactionCreation() {

        Account account = new Account(2L,"acc2",null,700);
        accountRepository.save(account);
        assertNotNull(account);

        Optional<Transaction> transaction = transactionRepository.findById(1L);
        assertNotNull(transaction);

    }
}
