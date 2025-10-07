package mainProgram.command;

import mainProgram.service.TransactionService;
import mainProgram.util.InputHelper;

public class ExitCommand extends BaseCommand {

    public ExitCommand(TransactionService service, InputHelper input) {
        super(service, input, "Avsluta");
    }

    @Override
    public void execute() {
        System.out.println("Programmet avslutas...");
    }
}
