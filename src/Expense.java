import java.time.LocalDate;

public class Expense {
    private int id;
    private String title;
    private double amount;
    private Category category;
    private LocalDate date;

    public Expense(int id, String title, double amount, Category category, LocalDate date) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + date + " | " + title + " | " + category + " | ₹" + amount;
    }

    public String toFileString() {
        return id + "," + title + "," + amount + "," + category + "," + date;
    }

    public static Expense fromFileString(String line) {
        String[] parts = line.split(",");

        int id = Integer.parseInt(parts[0]);
        String title = parts[1];
        double amount = Double.parseDouble(parts[2]);
        Category category = Category.valueOf(parts[3]);
        LocalDate date = LocalDate.parse(parts[4]);

        return new Expense(id, title, amount, category, date);
    }
}