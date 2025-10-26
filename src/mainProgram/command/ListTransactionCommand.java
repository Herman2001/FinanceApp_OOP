package mainProgram.command;

import mainProgram.model.Transaction;
import mainProgram.service.TransactionService;
import mainProgram.util.InputHelper;
import java.util.List;

public class ListTransactionCommand extends BaseCommand {

    public ListTransactionCommand(TransactionService service, InputHelper input) {
        super(service, input, "Lista alla");
    }

    @Override
    public void execute() {
        List<Transaction> all = service.getAllTransactions();
        if(all.isEmpty()) {
            System.out.println("Inga transaktioner.");
            return;
        }
        all.forEach(System.out::println);
    }
}