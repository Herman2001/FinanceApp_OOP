package mainProgram.service;

import mainProgram.model.Transaction;

public class ShowBalanceObserver implements TransactionObserver {

    private final TransactionService service;

    public ShowBalanceObserver(TransactionService service) {
        this.service = service;
    }
    @Override
    public void transactionUpdated(Transaction t) {
        System.out.println("Observer: Saldo uppdaterat -> " + service.getBalance());
    }

}
