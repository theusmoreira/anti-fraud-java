package com.example.anti_fraud.domains;

import lombok.Value;

@Value
public class TransactionModel {
  private String id;
  private String userId;
  private int value;
  private TransactionStatus status;
}