import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class ExpenseManager {

    private ArrayList<Expense> expenses;
    private int nextId;

    public ExpenseManager() {
        expenses = FileHandler.loadExpenses();

        nextId = 1;
        for (Expense e : expenses) {
            if (e.getId() >= nextId) {
                nextId = e.getId() + 1;
            }
        }
    }

    public void addExpense(String title, double amount, Category category, LocalDate date) {
        Expense expense = new Expense(nextId, title, amount, category, date);
        expenses.add(expense);
        nextId++;

        FileHandler.saveExpenses(expenses);
        System.out.println("Expense added successfully with ID: " + expense.getId());
    }

    public void viewAllExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("\n--- All Expenses ---");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    public void viewByCategory(Category category) {
        System.out.println("\n--- Expenses in " + category + " ---");
        boolean found = false;

        for (Expense expense : expenses) {
            if (expense.getCategory() == category) {
                System.out.println(expense);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No expenses found in this category.");
        }
    }

    public double calculateMonthlyTotal(int year, int month) {
        double total = 0;

        for (Expense expense : expenses) {
            if (expense.getDate().getYear() == year && expense.getDate().getMonthValue() == month) {
                total += expense.getAmount();
            }
        }
        return total;
    }

    public void showBudgetStatus(Student student, int year, int month) {
        double monthlyTotal = calculateMonthlyTotal(year, month);
        double budget = student.getMonthlyBudget();

        System.out.println("\nTotal spent in " + month + "/" + year + ": ₹" + monthlyTotal);
        System.out.println("Budget: ₹" + budget);

        if (monthlyTotal > budget) {
            System.out.println("❌ ALERT: Budget exceeded!");
        } else if (monthlyTotal >= 0.8 * budget) {
            System.out.println("⚠ Warning: You have used 80% of your budget.");
        } else {
            System.out.println("✔ You are within your budget.");
        }
    }

    public void deleteExpense(int id) {
        boolean removed = expenses.removeIf(expense -> expense.getId() == id);

        if (removed) {
            FileHandler.saveExpenses(expenses);
            System.out.println("Expense deleted successfully.");
        } else {
            System.out.println("Expense ID not found.");
        }
    }

    public void updateExpense(int id, String title, double amount, Category category, LocalDate date) {
        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                expense.setTitle(title);
                expense.setAmount(amount);
                expense.setCategory(category);
                expense.setDate(date);

                FileHandler.saveExpenses(expenses);
                System.out.println("Expense updated successfully.");
                return;
            }
        }
        System.out.println("Expense ID not found.");
    }

    public void sortByAmount() {
        expenses.sort(Comparator.comparingDouble(Expense::getAmount));
        System.out.println("Expenses sorted by amount.");
    }

    public void sortByDate() {
        expenses.sort(Comparator.comparing(Expense::getDate));
        System.out.println("Expenses sorted by date.");
    }

    public void showHighestExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses available.");
            return;
        }

        Expense max = expenses.get(0);
        for (Expense e : expenses) {
            if (e.getAmount() > max.getAmount()) {
                max = e;
            }
        }

        System.out.println("Highest Expense: " + max);
    }

    public void showLowestExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses available.");
            return;
        }

        Expense min = expenses.get(0);
        for (Expense e : expenses) {
            if (e.getAmount() < min.getAmount()) {
                min = e;
            }
        }

        System.out.println("Lowest Expense: " + min);
    }

    public void showCategorySummary() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("\n--- Category Wise Summary ---");
        for (Category category : Category.values()) {
            double total = 0;
            for (Expense expense : expenses) {
                if (expense.getCategory() == category) {
                    total += expense.getAmount();
                }
            }
            System.out.println(category + " : ₹" + total);
        }
    }

    public void exportMonthlyReport(int year, int month) {
        String fileName = "MonthlyReport_" + year + "_" + month + ".txt";

        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(fileName))) {

            writer.write("===== Monthly Expense Report =====\n");
            writer.write("Month: " + month + " Year: " + year + "\n\n");

            double total = 0;

            for (Expense expense : expenses) {
                if (expense.getDate().getYear() == year && expense.getDate().getMonthValue() == month) {
                    writer.write(expense.toString());
                    writer.newLine();
                    total += expense.getAmount();
                }
            }

            writer.write("\nTotal Expense: ₹" + total);
            writer.newLine();

            System.out.println("Monthly report exported successfully: " + fileName);

        } catch (Exception e) {
            System.out.println("Error exporting report: " + e.getMessage());
        }
    }
}