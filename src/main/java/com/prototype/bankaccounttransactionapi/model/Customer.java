package com.prototype.bankaccounttransactionapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id @GeneratedValue
    @Column(name = "customer_id")
    private Long customerId;
    private String name;
    private String surname;
    private double balance;
    @OneToMany(mappedBy="customer", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Account> accounts;

    public Customer(String name, String surname, double balance, List <Account> accounts) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Double.compare(customer.balance, balance) == 0 && Objects.equals(customerId, customer.customerId) && Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname) && Objects.equals(accounts, customer.accounts);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                ", accounts=" + accounts +
                '}';
    }
}
