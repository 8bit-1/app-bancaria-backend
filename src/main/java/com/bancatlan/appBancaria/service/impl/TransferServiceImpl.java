package com.bancatlan.appBancaria.service.impl;

import com.bancatlan.appBancaria.dto.transfer.TransferResponse;
import com.bancatlan.appBancaria.entity.Account;
import com.bancatlan.appBancaria.entity.Transfer;
import com.bancatlan.appBancaria.exception.AccountNotFoundException;
import com.bancatlan.appBancaria.exception.TransferNotFoundException;
import com.bancatlan.appBancaria.repository.AccountRepository;
import com.bancatlan.appBancaria.repository.TransferRepository;
import com.bancatlan.appBancaria.service.TransferService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    private TransferRepository transferRepository;
    private AccountRepository accountRepository;

    public TransferServiceImpl(TransferRepository transferRepository, AccountRepository accountRepository){
        this.transferRepository = transferRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public TransferResponse createTransfer(Long sourceId, Long destinationId, BigDecimal amount) {
        if (sourceId.equals(destinationId)) {
            throw new IllegalArgumentException("Las cuentas de origen y destino no pueden ser iguales");
        }

//        VALIDACIONES
        Account sourceAccount = accountRepository.findById(sourceId)
                .orElseThrow(() -> new EntityNotFoundException("Cuenta origen no encontrada"));

        Account destinationAccount = accountRepository.findById(destinationId)
                .orElseThrow(() -> new EntityNotFoundException("Cuenta destino no encontrada"));


        var balance = sourceAccount.getBalance();

        if(balance.compareTo(amount) < 0){
            throw new IllegalStateException("Saldo insuficiente");
        }
//        if (sourceAccount.getBalance().compareTo(amount) < 0) {
//            throw new IllegalStateException("Saldo insuficiente");
//        }

//        LOGICA DE GUARDADO
        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
        destinationAccount.setBalance(destinationAccount.getBalance().add(amount));

        // Se actualiza la tabla de cuentas, los saldos
        Transfer transfer = Transfer.builder()
                .sourceAccount(sourceAccount)
                .destinationAccount(destinationAccount)
                .amount(amount)
                .build();

        Transfer transferenciaCreada =  transferRepository.save(transfer);
        return  TransferResponse.fromEntity(transferenciaCreada);
    }

    @Override
    public TransferResponse getTransferById(Long id) {
        return transferRepository.findById(id)
                .map(TransferResponse::fromEntity)
                .orElseThrow(() ->  new TransferNotFoundException(id) );
    }

    @Override
    public List<TransferResponse> getOutgoingtransfersHistoryByAccount(Long accountId) {
        return transferRepository.findBySourceAccount_Id(accountId)
                .stream()
                .map(TransferResponse::fromEntity)
                .toList();
    }

    @Override
    public List<TransferResponse> getIncomingtransfersHistoryByAccount(Long accountId) {
        return transferRepository.findByDestinationAccount_Id(accountId)
                .stream()
                .map(TransferResponse::fromEntity)
                .toList();
    }
}
