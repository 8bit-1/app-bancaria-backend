package com.bancatlan.appBancaria.service;

import com.bancatlan.appBancaria.dto.account.AccountResponse;

import java.util.List;

public interface AccountService {

    AccountResponse getAccountById(Long id);
    List<AccountResponse> getAllAccounts();

}
