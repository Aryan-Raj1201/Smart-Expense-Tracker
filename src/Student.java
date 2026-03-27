public class Student {
    private String name;
    private double monthlyBudget;

    public Student(String name, double monthlyBudget) {
        this.name = name;
        this.monthlyBudget = monthlyBudget;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    public void setMonthlyBudget(double monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }
}