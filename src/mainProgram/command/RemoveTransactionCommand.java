package mainProgram.command;

import mainProgram.model.Transaction;
import mainProgram.service.TransactionService;
import mainProgram.util.InputHelper;

import java.util.List;

public class RemoveTransactionCommand extends BaseCommand {

    public RemoveTransactionCommand(TransactionService service, InputHelper input) {
        super(service, input, "Ta bort transaktion");
    }

    @Override
    public void execute() {
        executeWithErrorHandling(() -> {
           List<Transaction> all = service.getAllTransactions();
            if (all.isEmpty()) {
                System.out.println("Inga transaktioner hittades.");
                return;
            }

            displayTransactions(all);
            int index = input.promptForInt("Välj index att ta bort", 0, all.size() - 1);
            service.removeTransaction(all.get(index));
            System.out.println("Transaktion borttagen.");
        });
    }

    private void displayTransactions(List<Transaction> transactions) {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println((i) + ". " + transactions.get(i));
        }
    }
}
