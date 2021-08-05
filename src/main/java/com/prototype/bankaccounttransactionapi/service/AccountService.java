package com.prototype.bankaccounttransactionapi.service;

import com.prototype.bankaccounttransactionapi.model.Account;
import com.prototype.bankaccounttransactionapi.model.AccountRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    ResponseEntity<String> createAccount(AccountRequest accountRequest) throws Exception;
}
