package mainProgram.command;

import mainProgram.service.TransactionService;
import mainProgram.util.InputHelper;

public abstract class BaseCommand implements Command {
    protected final TransactionService service;
    protected final InputHelper input;
    private final String description;

    protected BaseCommand(TransactionService service, InputHelper input, String description) {
        this.service = service;
        this.input = input;
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    protected void executeWithErrorHandling(Runnable action) {
        try {
            action.run();
        } catch (Exception e) {
            System.out.println("Fel: " + e.getMessage());
        }
    }
}
