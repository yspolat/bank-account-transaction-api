package com.prototype.bankaccounttransactionapi.service;

import com.prototype.bankaccounttransactionapi.model.Account;
import com.prototype.bankaccounttransactionapi.model.AccountRequest;
import com.prototype.bankaccounttransactionapi.model.Customer;
import com.prototype.bankaccounttransactionapi.model.Transaction;
import com.prototype.bankaccounttransactionapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionService transactionService;

    @Override
    public List<Account> getAllAccounts() {
        return this.accountRepository.findAll();
    }

    @Override
    public ResponseEntity<String> createAccount(AccountRequest accountRequest) throws Exception {
        Customer customer = customerService.getCustomerByCustomerID(accountRequest.getCustomerID());
        if (customer == null) {
            throw new Exception("Account couldn't be opened because of no customer found for specified customer ID");
        }
        double initialCredit = accountRequest.getInitialCredit();
        Account account = new Account();
        account.setAccountName(accountRequest.getAccountName());
        account.setInitialCredit(initialCredit);
        account.setCustomerId(accountRequest.getCustomerID());
        this.accountRepository.save(account);

        if (initialCredit > 0) {
            // New transaction
            Transaction transaction = new Transaction();
            transaction.setAccount(account);
            transaction.setCustomerID(accountRequest.getCustomerID());
            transaction.setAmount(initialCredit);
            transaction.setAction("Initial");
            transaction.setTransactionStatus(String.valueOf(Transaction.TransactionType.CLEARED));
            transaction.setTransactionDate(new Date());
            transactionService.createTransaction(transaction);
        }
        return new ResponseEntity<>("Account has been added!", HttpStatus.OK);
    }
}
