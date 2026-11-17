package com.bancatlan.appBancaria.repository;

import com.bancatlan.appBancaria.dto.transfer.TransferResponse;
import com.bancatlan.appBancaria.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    boolean existsById(Long id);

    List<Transfer> findBySourceAccount_Id(Long sourceAccountId);

    List<Transfer> findByDestinationAccount_Id(Long destinationAccountId);
}
