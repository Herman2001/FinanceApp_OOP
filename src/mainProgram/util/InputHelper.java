package mainProgram.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputHelper {
    private final Scanner scanner;

    public InputHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public int promptForInt(String message, int min, int max) {
        while(true) {
            System.out.print(message);
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if(value < min || value > max) System.out.println("Värde mellan " + min + " och " + max);
                else return value;
            } catch(NumberFormatException e) { System.out.println("Ogiltigt tal."); }
        }
    }

    public double promptForDouble(String message) {
        while(true) {
            System.out.print(message);
            try { return Double.parseDouble(scanner.nextLine()); }
            catch(NumberFormatException e) { System.out.println("Ogiltigt tal."); }
        }
    }

    public String promptForString(String message) {
        while(true) {
            System.out.print(message);
            String s = scanner.nextLine();
            if(!s.isBlank()) return s;
            System.out.println("Får inte vara tomt.");
        }
    }

    public String promptForOptionalString(String message) {
        while(true) {
            System.out.print(message);
            String s = scanner.nextLine();
            return s.isBlank() ? null : s;
        }
    }

    public LocalDate promptForDateOrToday(String message) {
        System.out.print(message);
        String input = scanner.nextLine();
        if(input.isBlank()) return LocalDate.now();
        try { return LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd")); }
        catch(DateTimeParseException e) { return LocalDate.now(); }
    }
}
