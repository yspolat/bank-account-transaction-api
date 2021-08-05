package com.prototype.bankaccounttransactionapi.service;

import com.prototype.bankaccounttransactionapi.model.Customer;
import com.prototype.bankaccounttransactionapi.repository.AccountRepository;
import com.prototype.bankaccounttransactionapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByCustomerID(long customerID) {
        Optional<Customer> customer = customerRepository.findById(customerID);
        return customer.isPresent() ? customer.get() : null;
    }
}
