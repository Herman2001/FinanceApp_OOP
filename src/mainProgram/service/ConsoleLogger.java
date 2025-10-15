package mainProgram.service;

import mainProgram.model.Transaction;

public class ConsoleLogger implements TransactionObserver {

    @Override
    public void transactionUpdated(Transaction t) {
        System.out.println("Observer: Transaction uppdaterad -> " + t);
    }
}
