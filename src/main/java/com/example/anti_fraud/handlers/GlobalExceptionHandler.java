package com.example.anti_fraud.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.anti_fraud.exceptions.TransactionAlreadyExitsException;
import com.example.anti_fraud.responses.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
  // ? é um wildcard que representa um tipo desconhecido. Isso significa que o método pode retornar
  // um ResponseEntity que contém um ApiResponse de qualquer tipo.
  // Isso é útil quando você não sabe de antemão qual tipo de dado será retornado, ou quando você
  // deseja criar um método genérico que pode lidar com diferentes tipos de respostas.
   
  @ExceptionHandler(TransactionAlreadyExitsException.class)
  public ResponseEntity<ApiResponse<?>> handleTransactionAlreadyExistsException(TransactionAlreadyExitsException ex) {
        ApiResponse<?> response = ApiResponse.fail("TRANSACTION_ALREADY_EXISTS", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGeneric(Exception ex) {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ApiResponse.fail("INTERNAL_ERROR", "Unexpected error occurred"));
    }
}
