package com.bancatlan.appBancaria.entity;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfers")
@Builder
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "source_account_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_source")
    )
    private Account sourceAccount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "destination_account_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_destination")
    )
    private Account destinationAccount;

//    @DecimalMin(value = "0.01", message = "El monto debe ser mayor a 0")
    @Column(name = "amount", nullable = false, precision = 18, scale = 2)
    private BigDecimal amount;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Transfer() {

    }

    public Transfer(Long id, Account sourceAccount, Account destinationAccount, BigDecimal amount, LocalDateTime createdAt) {
        this.id = id;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
