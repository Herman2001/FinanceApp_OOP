package mainProgram.command;

import mainProgram.model.Transaction;
import mainProgram.service.TransactionService;
import mainProgram.util.InputHelper;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public class FilterTransactionCommand extends BaseCommand {

    public FilterTransactionCommand(TransactionService service, InputHelper input) {
        super(service, input, "Visa transaktioner för vald period");
    }

    @Override
    public void execute() {
        executeWithErrorHandling(() -> {
            System.out.println("Välj period: 1->År, 2->Månad, 3->Vecka, 4->Dag");
            int period = input.promptForInt("Val: ", 1, 4);

            List<Transaction> filtered = switch (period) {
                case 1 -> filterByYear();
                case 2 -> filterByMonth();
                case 3 -> filterByWeek();
                case 4 -> filterByDay();
                default -> List.of();
            };

            displayResults(filtered);
        });
    }

    private List<Transaction> filterByYear() {
        int year = input.promptForInt("Skriv in år (YYYY): ", 2000, 2100);
        return service.filterByYear(year);
    }

    private List<Transaction> filterByMonth() {
        YearMonth month = YearMonth.parse(input.promptForString("Skriv in månad (YYYY-MM): "));
        return service.filterByMonth(month);
    }

    private List<Transaction> filterByWeek() {
        int year = input.promptForInt("Skriv in år (YYYY): ", 2000, 2100);
        int week = input.promptForInt("Skriv in vecka (1–52): ", 1, 52);
        return service.filterByWeek(year, week);
    }

    private List<Transaction> filterByDay() {
        LocalDate day = input.promptForDateOrToday("Skriv in dag (YYYY-MM-DD, tomt = idag): ");
        return service.filterByDay(day);
    }

    private void displayResults(List<Transaction> filtered) {
        if (filtered.isEmpty()) {
            System.out.println("Inga transaktioner hittades.");
            return;
        }

        // Olika sätt att skriva på

        // Lambda
        filtered.forEach(System.out::println);

        // Enhanced loop
/*        for (Transaction element : filtered) {
            System.out.println(element);
        }*/

        // "Vanlig" for-loop
/*        for (int i = 0; i < filtered.size(); i++) {
            System.out.println(filtered.get(i));
        }*/
        double income = service.sumIncome(filtered);
        double expenses = service.sumExpenses(filtered);
        double result = income + expenses;

        System.out.println("\nInkomst: " + income + " kr");
        System.out.println("Utgifter: " + expenses + " kr");
        System.out.println("Resultat: " + result + " kr");
    }
}
