package com.prototype.bankaccounttransactionapi.repository;

import com.prototype.bankaccounttransactionapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
