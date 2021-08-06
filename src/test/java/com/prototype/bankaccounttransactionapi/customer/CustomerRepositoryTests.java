package com.prototype.bankaccounttransactionapi.customer;

import com.prototype.bankaccounttransactionapi.model.Customer;
import com.prototype.bankaccounttransactionapi.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testCustomerCreation() throws Exception {
        Customer customer = new Customer("Yavuz Selim","Polat",500, null);
        Customer savedCustomer = customerRepository.save(customer);
        assertNotNull(savedCustomer);
    }
}
