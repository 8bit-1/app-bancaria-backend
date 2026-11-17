package com.bancatlan.appBancaria.exception;

public class TransfersNotFoundException extends RuntimeException {
    public TransfersNotFoundException(Long id) {
        super("No se encontró la transferencia perteneciente a la cuenta: " + id);
    }
}
