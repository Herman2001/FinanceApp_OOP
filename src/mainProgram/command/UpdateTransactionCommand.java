package mainProgram.command;

import mainProgram.model.Transaction;
import mainProgram.service.TransactionService;
import mainProgram.util.InputHelper;

import java.time.LocalDate;
import java.util.List;

public class UpdateTransactionCommand extends BaseCommand {

    public UpdateTransactionCommand(TransactionService service, InputHelper  input) {
        super(service, input, "Ändra befintlig transaktion");
    }

    @Override
    public void execute() {
        executeWithErrorHandling(() -> {
            List<Transaction> all = service.getAllTransactions();
            if (all.isEmpty()) {
                System.out.println("Inga transaktionen hittades.");
                return;
            }

            displayTransactions(all);
            int index = input.promptForInt("Välj index att uppdatera: ", 0, all.size() - 1);

            String newDesc = input.promptForOptionalString("Ny beskrivning: ");
            String amountInput = input.promptForOptionalString("Nytt belopp: ");
            String dateInput = input.promptForOptionalString("Nytt datum (YYYY-MM-DD): ");

            double newAmount = (amountInput == null || amountInput.isBlank()) ? Double.NaN : Double.parseDouble(amountInput);
            LocalDate newDate = (dateInput == null || dateInput.isBlank()) ? null : LocalDate.parse(dateInput);
            newDesc = (newDesc == null || newDesc.isBlank()) ? null : newDesc;

            service.updateTransaction(index, newDesc, newAmount, newDate);
            System.out.println("Transaktion uppdaterad!");
        });
    }

    private void displayTransactions(List<Transaction> transactions) {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(i + ": " + transactions.get(i));
        }
    }
}
