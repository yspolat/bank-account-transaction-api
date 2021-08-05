package com.prototype.bankaccounttransactionapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequest {

    @JsonProperty("customerID")
    private Long customerID;

    @JsonProperty("initialCredit")
    private double initialCredit;

    @JsonProperty("accountName")
    private String accountName;

    public AccountRequest(Long customerID, double initialCredit, String accountName) {
        this.customerID = customerID;
        this.initialCredit = initialCredit;
        this.accountName = accountName;
    }
}
