package com.example.anti_fraud.repositories;

import java.util.HashMap;
import java.util.Map;

import com.example.anti_fraud.domains.TransactionModel;

public class TransactionInMemoryRepository {
    private final Map<String, TransactionModel> transactions = new HashMap<>();


    public TransactionModel save(TransactionModel transaction) {
        transactions.put(transaction.getId(), transaction);
        return transaction;
    }

    public TransactionModel findById(String id) {
        return transactions.get(id);
    }

    public void deleteById(String id) {
        transactions.remove(id);
    }

    public Map<String, TransactionModel> findAll() {
        return transactions;
    }
}

