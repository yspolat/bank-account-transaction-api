package com.prototype.bankaccounttransactionapi.repository;

import com.prototype.bankaccounttransactionapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("accountRepository")
public interface AccountRepository extends JpaRepository<Account, Long> {
}
