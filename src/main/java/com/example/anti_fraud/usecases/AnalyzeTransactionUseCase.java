package com.example.anti_fraud.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.anti_fraud.domains.Transaction;
import com.example.anti_fraud.domains.TransactionStatus;
import com.example.anti_fraud.dtos.TransactionDTO;
import com.example.anti_fraud.exceptions.TransactionAlreadyExitsException;
import com.example.anti_fraud.repositories.TransactionInMemoryRepository;

@Service
public class AnalyzeTransactionUseCase {
  @Autowired
  TransactionInMemoryRepository transactionInMemoryRepository;

  public TransactionStatus execute(TransactionDTO data) {

    
    Transaction transactionAlreadyExists = transactionInMemoryRepository.findById(data.getId());
    if (transactionAlreadyExists != null) {
      throw new TransactionAlreadyExitsException("Transação já foi analisada");
    }

    TransactionStatus status = TransactionStatus.PENDING;

    if (data.getValue() > 1000) {
      status = TransactionStatus.APPROVAL_REQUIRED;
    } else {
      status = TransactionStatus.APPROVED;
    }

    Transaction transaction = new Transaction(data.getId(), data.getUserId(), data.getValue(), status);
    transactionInMemoryRepository.save(transaction);

    return status;
  }
}
