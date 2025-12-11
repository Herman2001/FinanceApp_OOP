package mainProgram.model;

import java.time.LocalDate;
import java.time.temporal.WeekFields;

public class Transaction {
    private final int transactionId;
    private final int userId;
    private final String description;
    private final double amount;
    private final LocalDate date;
    private final int week;

    // Konstruktor för transaktioner som redan finns i DB
    public Transaction(int transactionId, int userId, String description, double amount, LocalDate date) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.description = description;
        this.amount = amount;
        this.date = date;

        WeekFields wf = WeekFields.ISO;
        this.week = date.get(wf.weekOfYear());
    }

    // Konstruktor för nya transaktioner som ska sparas till DB
    public Transaction(int userId, String description, double amount, LocalDate date) {
        this(0, userId, description, amount, date);
    }

    public int getTransactionId() {
        return transactionId;
    }
    public int getUserId() {
        return userId;
    }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public int getWeek() { return week; }

    public String toCSV() {
        return date + "," + description + "," + amount;
    }

    @Override
    public String toString() {
        return date + " | week: " + week + " | " + description + " | " + amount + "kr";
    }
}
