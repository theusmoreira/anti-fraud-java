package com.example.anti_fraud.responses;

import com.example.anti_fraud.domains.TransactionStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransactionResult {
  private String id;
  private TransactionStatus status;
}
