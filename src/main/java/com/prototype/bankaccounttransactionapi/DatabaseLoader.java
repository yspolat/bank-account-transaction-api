package com.prototype.bankaccounttransactionapi;

import com.prototype.bankaccounttransactionapi.model.Customer;
import com.prototype.bankaccounttransactionapi.repository.AccountRepository;
import com.prototype.bankaccounttransactionapi.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
class DatabaseLoader {
    @Bean
    CommandLineRunner init(CustomerRepository customerRepository) {

        return args -> {
            customerRepository.save(new Customer("John","Doe",500, null));
            customerRepository.save(new Customer("Jane","Doe",1000, null));
        };
    }
}