package com.bancatlan.appBancaria.dto.account;

import com.bancatlan.appBancaria.entity.Account;

import java.math.BigDecimal;

public record AccountResponse(
        Long id,
        String holderName,
        BigDecimal balance
) {
    public static AccountResponse fromEntity(Account account) {
        return new AccountResponse(
                account.getId(),
                account.getHolderName(),
                account.getBalance()
        );
    }
}