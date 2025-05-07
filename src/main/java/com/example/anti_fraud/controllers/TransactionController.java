package com.example.anti_fraud.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anti_fraud.domains.TransactionStatus;
import com.example.anti_fraud.dtos.TransactionDTO;
import com.example.anti_fraud.responses.ApiResponse;
import com.example.anti_fraud.responses.TransactionResult;
import com.example.anti_fraud.usecases.AnalyzeTransactionUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
  @Autowired
  private AnalyzeTransactionUseCase analyzeTransactionUseCase;

  @PostMapping()
  public ResponseEntity<ApiResponse<TransactionResult>> analyzeTransaction(@RequestBody TransactionDTO data) {
    System.out.println("Transaction received: " + data);

     TransactionStatus result = analyzeTransactionUseCase.execute(data);

    TransactionResult transactionResult = new TransactionResult(data.getId(), result);
    return ResponseEntity.ok(ApiResponse.ok(transactionResult));
  }
}
