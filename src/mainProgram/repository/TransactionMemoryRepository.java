package mainProgram.repository;

import mainProgram.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionMemoryRepository {
    private final TransactionRepository transactionRepository;
    private final List<Transaction> transactions;

    public TransactionMemoryRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
        this.transactions = new ArrayList<>(transactionRepository.load());
    }

    public void add(Transaction transaction) {
        transactions.add(transaction);
    }

    public void remove(Transaction transaction) {
        transactions.remove(transaction);
    }

    public void update(int index, Transaction newTransaction) {
        if(index < 0 || index >= transactions.size()) return;
        transactions.set(index, newTransaction);
    }

    public List<Transaction> getAll() {
        return new ArrayList<>(transactions);
    }

    public void saveAll() {
        transactionRepository.save(transactions);
    }
}