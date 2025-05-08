package com.example.anti_fraud.entities;


import com.example.anti_fraud.domains.TransactionModel;
import com.example.anti_fraud.domains.TransactionStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class TransactionEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String userId;

  private int value;

  @Enumerated(EnumType.STRING)
  private TransactionStatus status;


  public TransactionModel toDomain() {
    return new TransactionModel(id, userId, value, status);
  }

  public static TransactionEntity fromDomain(TransactionModel transactionModel) {
    return TransactionEntity.builder()
        .id(transactionModel.getId())
        .userId(transactionModel.getUserId())
        .value(transactionModel.getValue())
        .status(transactionModel.getStatus())
        .build();
  }
}
