package com.example.anti_fraud.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Transaction {
  private String id;
  private String userId;
  private int value;
  private TransactionStatus status;
}