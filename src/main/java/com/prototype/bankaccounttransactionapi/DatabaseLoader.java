package com.prototype.bankaccounttransactionapi;

import com.prototype.bankaccounttransactionapi.model.Customer;
import com.prototype.bankaccounttransactionapi.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
class DatabaseLoader {
    @Bean
    CommandLineRunner init(CustomerRepository repository) {

        return args -> {
            repository.save(new Customer("John","Doe",1000,0,null));
        };
    }
}