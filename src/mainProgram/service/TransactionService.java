package mainProgram.service;

import mainProgram.model.Transaction;
import mainProgram.repository.TransactionMemoryRepository;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionService {
    private final TransactionMemoryRepository repo;

    public TransactionService(TransactionMemoryRepository repo) {
        this.repo = repo;
    }

    public void addTransaction(Transaction transaction) { repo.add(transaction); repo.saveAll(); }
    public void removeTransaction(Transaction transaction) { repo.remove(transaction); repo.saveAll(); }
    public List<Transaction> getAllTransactions() { return repo.getAll(); }
    public double getBalance() { return repo.getAll().stream().mapToDouble(Transaction::getAmount).sum(); }

    public void updateTransaction(int index, String newDesc, double newAmount, LocalDate newDate) {
        List<Transaction> all = repo.getAll();
        if(index < 0 || index >= all.size()) return;

        Transaction oldT = all.get(index);

        String desc = newDesc != null ? newDesc : oldT.getDescription();
        double amount = !Double.isNaN(newAmount) ? newAmount : oldT.getAmount();
        LocalDate date = newDate != null ? newDate : oldT.getDate();

        Transaction updated = new Transaction(desc, amount, date);
        repo.update(index, updated);
        repo.saveAll();
    }

    public List<Transaction> filterByYear(int year) {
        return repo.getAll().stream()
                .filter(t -> t.getDate().getYear() == year)
                .collect(Collectors.toList());
    }

    public List<Transaction> filterByMonth(YearMonth month) {
        return repo.getAll().stream()
                .filter(t -> YearMonth.from(t.getDate()).equals(month))
                .collect(Collectors.toList());
    }

    public List<Transaction> filterByWeek(int year, int week) {
        WeekFields wf = WeekFields.ISO;
        return repo.getAll().stream()
                .filter(t -> t.getDate().get(wf.weekBasedYear()) == year && t.getWeek() == week)
                .collect(Collectors.toList());
    }

    public List<Transaction> filterByDay(LocalDate day) {
        return repo.getAll().stream()
                .filter(t -> t.getDate().equals(day))
                .collect(Collectors.toList());
    }

    public double sumIncome(List<Transaction> list) {
        return list.stream().filter(t -> t.getAmount() > 0).mapToDouble(Transaction::getAmount).sum();
    }

    public double sumExpenses(List<Transaction> list) {
        return list.stream().filter(t -> t.getAmount() < 0).mapToDouble(Transaction::getAmount).sum();
    }
}
