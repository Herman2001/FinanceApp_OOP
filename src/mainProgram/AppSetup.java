package mainProgram;

import mainProgram.command.*;
import mainProgram.repository.CsvTransactionRepository;
import mainProgram.repository.TransactionMemoryRepository;
import mainProgram.repository.TransactionRepository;
import mainProgram.service.TransactionService;
import mainProgram.util.InputHelper;

import java.util.List;
import java.util.Scanner;

public class AppSetup {

    private final TransactionService service;
    private final InputHelper input;
    private final List<Command> commands;

    public AppSetup() {
        var scanner = new Scanner(System.in);
        this.input = new InputHelper(scanner);

        TransactionRepository csvRepo = new CsvTransactionRepository("transactions.csv");
        TransactionMemoryRepository memoryRepo = new TransactionMemoryRepository(csvRepo);
        this.service = new TransactionService(memoryRepo);

        this.commands = List.of (
            new AddTransactionCommand(service, input),
            new RemoveTransactionCommand(service, input),
            new UpdateTransactionCommand(service, input),
            new ListTransactionCommand(service, input),
            new FilterTransactionCommand(service, input),
            new ShowBalanceCommand(service, input),
            new ExitCommand(service, input)
        );
    }

    public TransactionService getService() { return service; }
    public InputHelper getInput() { return input; }
    public List<Command> getCommands() { return commands; }
}
