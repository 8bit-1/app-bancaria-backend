package com.bancatlan.appBancaria.dto.transfer;

import com.bancatlan.appBancaria.entity.Transfer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransferResponse(
        Long id,
        Long sourceAccountId,
        Long destinationAccountId,
        BigDecimal amount,
        LocalDateTime createdAt
) {
    public static TransferResponse fromEntity(Transfer transfer) {
        return new TransferResponse(
                transfer.getId(),
                transfer.getSourceAccount().getId(),
                transfer.getDestinationAccount().getId(),
                transfer.getAmount(),
                transfer.getCreatedAt()
        );
    }
}