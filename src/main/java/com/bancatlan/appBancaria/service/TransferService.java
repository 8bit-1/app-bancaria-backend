package com.bancatlan.appBancaria.service;

import com.bancatlan.appBancaria.dto.account.AccountResponse;
import com.bancatlan.appBancaria.dto.transfer.TransferResponse;
import com.bancatlan.appBancaria.entity.Transfer;

import java.math.BigDecimal;
import java.util.List;

public interface TransferService {

    TransferResponse getTransferById(Long id);
    List<TransferResponse> getOutgoingtransfersHistoryByAccount(Long accountId);
    List<TransferResponse> getIncomingtransfersHistoryByAccount(Long accountId);
    public TransferResponse createTransfer(Long sourceId, Long destinationId, BigDecimal amount);
}
