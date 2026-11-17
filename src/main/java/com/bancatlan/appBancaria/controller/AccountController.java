package com.bancatlan.appBancaria.controller;

import com.bancatlan.appBancaria.dto.account.AccountResponse;
import com.bancatlan.appBancaria.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @GetMapping
    public ResponseEntity<List<AccountResponse>> getAll() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
}
