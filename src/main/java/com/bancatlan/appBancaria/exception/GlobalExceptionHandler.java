package com.bancatlan.appBancaria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(AccountAlreadyExistsException.class)
//    public ProblemDetail handleAccountExists(AccountAlreadyExistsException ex) {
//        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());
//        problem.setTitle("Cuenta duplicada");
//        problem.setProperty("timestamp", Instant.now());
//        return problem;
//    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ProblemDetail handleAccountNotFound(AccountNotFoundException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problem.setTitle("Cuenta no encontrada");
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

//    @ExceptionHandler(InsufficientFundsException.class)
//    public ProblemDetail handleInsufficientFunds(InsufficientFundsException ex) {
//        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
//        problem.setTitle("Fondos insuficientes");
//        problem.setProperty("timestamp", Instant.now());
//        return problem;
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ProblemDetail handleValidationErrors(MethodArgumentNotValidException ex) {
//        String errors = ex.getBindingResult().getFieldErrors().stream()
//                .map(err -> err.getField() + ": " + err.getDefaultMessage())
//                .collect(Collectors.joining(", "));
//
//        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, errors);
//        problem.setTitle("Error de validación en los datos enviados");
//        problem.setProperty("timestamp", Instant.now());
//        return problem;
//    }
}

