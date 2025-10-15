package mainProgram.service;

import mainProgram.model.Transaction;

public interface TransactionObserver {
    void transactionUpdated(Transaction t);
}