package com.bancatlan.appBancaria.service.impl;

import com.bancatlan.appBancaria.dto.account.AccountResponse;
import com.bancatlan.appBancaria.exception.AccountNotFoundException;
import com.bancatlan.appBancaria.repository.AccountRepository;
import com.bancatlan.appBancaria.service.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
//    @Transactional()
    public AccountResponse getAccountById(Long id) {
        return accountRepository.findById(id)
                .map(AccountResponse::fromEntity)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    @Override
//    @Transactional(readOnly = true)
    public List<AccountResponse> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(AccountResponse::fromEntity)
                .toList();
    }

}
