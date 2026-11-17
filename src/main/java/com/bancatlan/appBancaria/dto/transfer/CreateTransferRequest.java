package com.bancatlan.appBancaria.dto.transfer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record CreateTransferRequest(

        @NotNull(message = "Cuenta origen es obligatoria")
        Long sourceAccount,

        @NotNull(message = "Cuenta destino es obligatoria")
        Long destinationAccount,

        @NotNull(message = "Monto es obligatorio")
        @PositiveOrZero(message = "El saldo a transferir no puede ser negativo")
        BigDecimal amount

) {}