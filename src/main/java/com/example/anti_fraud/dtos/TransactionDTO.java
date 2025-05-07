package com.example.anti_fraud.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransactionDTO {
  private String id;
  private String userId;
  private int value;
}
