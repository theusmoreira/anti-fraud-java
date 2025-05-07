package com.example.anti_fraud.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.anti_fraud.domains.Transaction;

@Repository
public class TransactionInMemoryRepository {
    private final Map<String, Transaction> transactions = new HashMap<>();


    public Transaction save(Transaction transaction) {
        transactions.put(transaction.getId(), transaction);
        return transaction;
    }

    public Transaction findById(String id) {
        return transactions.get(id);
    }

    public void deleteById(String id) {
        transactions.remove(id);
    }

    public Map<String, Transaction> findAll() {
        return transactions;
    }
}

