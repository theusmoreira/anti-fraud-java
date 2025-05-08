package com.example.anti_fraud.repositories;

import java.util.Optional;

import com.example.anti_fraud.domains.TransactionModel;

public interface ITransactionRepository {
  void save(TransactionModel tx);
  Optional<TransactionModel> findById(String id);
}
