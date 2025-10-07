package mainProgram.command;

import mainProgram.service.TransactionService;
import mainProgram.util.InputHelper;

public class ShowBalanceCommand extends BaseCommand {

    public ShowBalanceCommand(TransactionService service, InputHelper input) {
        super(service, input, "Visa saldo");
    }

    @Override
    public void execute() {
        double balance = service.getBalance();
        System.out.println("Saldo: " + balance + " kr");
    }
}