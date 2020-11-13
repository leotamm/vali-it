package ee.bcs.valiiit.controller;

import java.math.BigDecimal;

public class Account {

    private String accountNr;
    private BigDecimal balance;
    private String name;
    private String address;

    public Account() {

    }

    public Account(String accountNr) {
        this.accountNr = accountNr;
        this.balance = BigDecimal.ZERO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountNr() {
        return accountNr;
    }

    public Account setAccountNr(String accountNr) {
        this.accountNr = accountNr;
        return this;
    }

}
