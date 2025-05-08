package com.example.anti_fraud.repositories;

import com.example.anti_fraud.domains.TransactionModel;
import com.example.anti_fraud.entities.TransactionEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepository implements ITransactionRepository {
  private final JpaRepository<TransactionEntity, String> jpaRepository;

  public TransactionRepository(JpaRepository<TransactionEntity, String> jpaRepository) {
    this.jpaRepository = jpaRepository;
  }

  @Override
  public void save(TransactionModel data) {
    TransactionEntity entity = TransactionEntity.fromDomain(data);
    jpaRepository.save(entity);
  }

  @Override
  public Optional<TransactionModel> findById(String id) {
    return jpaRepository.findById(id).map(TransactionEntity::toDomain);
  }
}