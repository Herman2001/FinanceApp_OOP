package mainProgram.command;

import mainProgram.model.Transaction;
import mainProgram.service.TransactionService;
import mainProgram.util.InputHelper;

import java.time.LocalDate;

public class AddTransactionCommand extends BaseCommand {

    public AddTransactionCommand(TransactionService service, InputHelper input) {
        super(service, input, "Lägg till transaktion");
    }

    @Override
    public void execute() {
        executeWithErrorHandling(() -> {
            String desc = input.promptForString("Beskrivning: ");
            double amount = input.promptForDouble("Belopp:  ");
            LocalDate date = input.promptForDateOrToday("Datum (YYYY-MM-DD) lämna tomt för dagens datum: ");
            service.addTransaction(new Transaction(desc, amount, date));
            System.out.println("Transaktion tillagd!");
        });
    }
}
