package com.example.anti_fraud.usecases;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.anti_fraud.domains.TransactionModel;
import com.example.anti_fraud.domains.TransactionStatus;
import com.example.anti_fraud.dtos.TransactionDTO;
import com.example.anti_fraud.exceptions.TransactionAlreadyExitsException;
import com.example.anti_fraud.repositories.ITransactionRepository;

@Service
public class AnalyzeTransactionUseCase {
  @Autowired
  ITransactionRepository transactionRepository;

  public TransactionStatus execute(TransactionDTO data) {

    
    Optional<TransactionModel> transactionAlreadyExists = transactionRepository.findById(data.getId());
    if (transactionAlreadyExists != null) {
      throw new TransactionAlreadyExitsException("Transação já foi analisada");
    }

    TransactionStatus status = TransactionStatus.PENDING;

    if (data.getValue() > 1000) {
      status = TransactionStatus.APPROVAL_REQUIRED;
    } else {
      status = TransactionStatus.APPROVED;
    }

    TransactionModel transaction = new TransactionModel(data.getId(), data.getUserId(), data.getValue(), status);
    transactionRepository.save(transaction);

    return status;
  }
}
