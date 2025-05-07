package com.example.anti_fraud.exceptions;

public class TransactionAlreadyExitsException extends RuntimeException {
  
  public TransactionAlreadyExitsException(String message) {
    super(message);
  }

  public TransactionAlreadyExitsException(String message, Throwable cause) {
    super(message, cause);
  }

  public TransactionAlreadyExitsException(Throwable cause) {
    super(cause);
  }
}
