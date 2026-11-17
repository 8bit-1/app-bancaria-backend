package com.bancatlan.appBancaria.controller;

import com.bancatlan.appBancaria.dto.account.AccountResponse;
import com.bancatlan.appBancaria.dto.transfer.CreateTransferRequest;
import com.bancatlan.appBancaria.dto.transfer.TransferResponse;
import com.bancatlan.appBancaria.service.AccountService;
import com.bancatlan.appBancaria.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transfer")
public class TransferController {

    private TransferService transferService;

    public TransferController(TransferService transferService){
        this.transferService = transferService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(transferService.getTransferById(id));
    }

    @GetMapping("/source/{id}")
    public ResponseEntity<List<TransferResponse>> getBySourceAccount( Long SourceAccountId) {
        return ResponseEntity.ok(transferService.getOutgoingtransfersHistoryByAccount(SourceAccountId));
    }

    @PostMapping()
    public ResponseEntity<TransferResponse> CreateTransfer(@RequestBody CreateTransferRequest request) {
        return ResponseEntity.ok(transferService.createTransfer(request.sourceAccount(),request.destinationAccount(),request.amount()));
    }
}
