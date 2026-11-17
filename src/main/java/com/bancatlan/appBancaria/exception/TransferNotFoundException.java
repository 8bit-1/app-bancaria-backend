package com.bancatlan.appBancaria.exception;

public class TransferNotFoundException extends RuntimeException {
    public TransferNotFoundException(Long id) {
        super("No se encontró la transferencia con ID: " + id);
    }
}
