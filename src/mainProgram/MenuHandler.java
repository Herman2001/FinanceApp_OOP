package mainProgram;

import mainProgram.command.Command;
import mainProgram.command.ExitCommand;
import mainProgram.util.InputHelper;

import java.util.List;

public class MenuHandler {
    private final List<Command> commands;
    private final InputHelper input;

    public MenuHandler(List<Command> commands, InputHelper input) {
        this.commands = commands;
        this.input = input;
    }

    public void run() {
        boolean running = true;
        System.out.println("Välkommen till FinanceApp!");

        while (running) {
            System.out.println("\n======= MENY =======");
            for (int i = 0; i < commands.size(); i++) {
                System.out.println((i + 1) + ": " + commands.get(i).getDescription());
            }

            int choice = input.promptForInt("> ", 1 , commands.size());
            Command selected = commands.get(choice - 1);

            selected.execute();

            if (selected instanceof ExitCommand) {
                running = false;
            }
        }
    }
}
