package com.prototype.bankaccounttransactionapi.service;

import com.prototype.bankaccounttransactionapi.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerByCustomerID(long customerID);
}
