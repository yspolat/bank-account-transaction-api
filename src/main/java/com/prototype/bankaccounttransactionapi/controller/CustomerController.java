package com.prototype.bankaccounttransactionapi.controller;

import com.prototype.bankaccounttransactionapi.model.Customer;
import com.prototype.bankaccounttransactionapi.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        LOGGER.info("getAllAccounts");
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }
}
