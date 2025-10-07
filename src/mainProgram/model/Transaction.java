package mainProgram.model;

import java.time.LocalDate;
import java.time.temporal.WeekFields;

public class Transaction {
    private final String description;
    private final double amount;
    private final LocalDate date;
    private final int week;

    public Transaction(String description, double amount, LocalDate date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        WeekFields wf = WeekFields.ISO;
        this.week = date.get(wf.weekOfYear());
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
