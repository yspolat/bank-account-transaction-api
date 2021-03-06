package com.prototype.bankaccounttransactionapi.controller;

import com.prototype.bankaccounttransactionapi.model.Account;
import com.prototype.bankaccounttransactionapi.model.AccountRequest;
import com.prototype.bankaccounttransactionapi.model.Customer;
import com.prototype.bankaccounttransactionapi.service.AccountService;
import com.prototype.bankaccounttransactionapi.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/account/all")
    public ResponseEntity<List<Account>> getAllAccounts(){
        return ResponseEntity.ok().body(accountService.getAllAccounts());
    }

    @PostMapping("/account")
    public ResponseEntity<String> createAccount(@RequestBody AccountRequest accountRequest) throws Exception {
        return accountService.createAccount(accountRequest);
    }
}
