import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Smart Expense Tracker =====");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Set your monthly budget: ");
        double budget = sc.nextDouble();
        sc.nextLine();

        Student student = new Student(name, budget);
        ExpenseManager manager = new ExpenseManager();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total Expense");
            System.out.println("4. View Expense by Category");
            System.out.println("5. View Monthly Expense & Budget Status");
            System.out.println("6. Delete Expense by ID");
            System.out.println("7. Update Expense by ID");
            System.out.println("8. Sort Expenses by Amount");
            System.out.println("9. Sort Expenses by Date");
            System.out.println("10. Highest Expense");
            System.out.println("11. Lowest Expense");
            System.out.println("12. Category Summary");
            System.out.println("13. Export Monthly Report");
            System.out.println("14. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter expense title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Select Category:");
                    for (Category c : Category.values()) {
                        System.out.println("- " + c);
                    }

                    System.out.print("Enter category: ");
                    Category category = Category.valueOf(sc.nextLine().toUpperCase());

                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());

                    manager.addExpense(title, amount, category, date);
                    break;

                case 2:
                    manager.viewAllExpenses();
                    break;

                case 3:
                    System.out.println("Total Expense: ₹" + manager.calculateTotal());
                    break;

                case 4:
                    System.out.print("Enter category: ");
                    Category cat = Category.valueOf(sc.nextLine().toUpperCase());
                    manager.viewByCategory(cat);
                    break;

                case 5:
                    System.out.print("Enter year: ");
                    int year = sc.nextInt();

                    System.out.print("Enter month (1-12): ");
                    int month = sc.nextInt();

                    manager.showBudgetStatus(student, year, month);
                    break;

                case 6:
                    System.out.print("Enter expense ID to delete: ");
                    int deleteId = sc.nextInt();
                    manager.deleteExpense(deleteId);
                    break;

                case 7:
                    System.out.print("Enter expense ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter new amount: ");
                    double newAmount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter new category: ");
                    Category newCategory = Category.valueOf(sc.nextLine().toUpperCase());

                    System.out.print("Enter new date (YYYY-MM-DD): ");
                    LocalDate newDate = LocalDate.parse(sc.nextLine());

                    manager.updateExpense(updateId, newTitle, newAmount, newCategory, newDate);
                    break;

                case 8:
                    manager.sortByAmount();
                    manager.viewAllExpenses();
                    break;

                case 9:
                    manager.sortByDate();
                    manager.viewAllExpenses();
                    break;

                case 10:
                    manager.showHighestExpense();
                    break;

                case 11:
                    manager.showLowestExpense();
                    break;

                case 12:
                    manager.showCategorySummary();
                    break;

                case 13:
                    System.out.print("Enter year: ");
                    int reportYear = sc.nextInt();

                    System.out.print("Enter month (1-12): ");
                    int reportMonth = sc.nextInt();

                    manager.exportMonthlyReport(reportYear, reportMonth);
                    break;

                case 14:
                    System.out.println("Exiting... Bye " + student.getName());
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}