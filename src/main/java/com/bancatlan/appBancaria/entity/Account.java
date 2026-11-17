package com.bancatlan.appBancaria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    private Long id;

    @Column(name = "holder_name", nullable = false)
    private String holderName;

//    @Column(nullable = false, precision = 19, scale = 4)
    @Column(name = "balance", nullable = false, precision = 18, scale = 2)
    private BigDecimal balance;

    public Account(){}

    public BigDecimal getBalance() {
        return balance;
    }

    public String getHolderName() {
        return holderName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
