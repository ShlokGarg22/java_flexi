import java.util.ArrayList;

// Employee Class
class Employee {

    private String employeeId;
    private String name;
    private String role;
    private double baseSalary;
    private double finalSalary;   // stores calculated salary

    public Employee(String employeeId, String name, String role, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    // Calculate salary using switch-case
    public void calculateSalary() {

        switch (role) {

            case "Manager":
                finalSalary = baseSalary + (baseSalary * 0.20);
                break;

            case "Developer":
                finalSalary = baseSalary + (baseSalary * 0.10);
                break;

            case "Designer":
                finalSalary = baseSalary + (baseSalary * 0.05);
                break;

            case "Intern":
                finalSalary = 1000;   // fixed salary
                break;

            default:
                System.out.println("Invalid role for employee: " + name);
                finalSalary = baseSalary;
        }
    }

    // Apply deduction
    public void applyDeduction(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid deduction amount.");
            return;
        }

        if (finalSalary == 0) {
            calculateSalary(); // ensure salary is calculated first
        }

        finalSalary -= amount;
        System.out.println("Deduction of $" + amount + " applied to " + name);
    }

    // Display employee details
    public void displayEmployeeDetails() {

        if (finalSalary == 0) {
            calculateSalary();
        }

        System.out.println("--------------------------------");
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Role        : " + role);
        System.out.println("Final Salary: $" + finalSalary);
        System.out.println("--------------------------------");
    }
}

// Payroll Class
class Payroll {

    private ArrayList<Employee> employees = new ArrayList<>();

    // Add employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    // Calculate and display all salaries
    public void calculateAllSalaries() {
        for (Employee emp : employees) {
            emp.calculateSalary();
            emp.displayEmployeeDetails();
        }
    }

    // Find employee by ID
    public Employee findEmployeeById(String employeeId) {

        for (Employee emp : employees) {
            if (emp.getEmployeeId().equals(employeeId)) {
                return emp;
            }
        }

        return null;
    }
}

// Main Class
public class Main {

    public static void main(String[] args) {

        Payroll payroll = new Payroll();

        // Create Employees
        Employee e1 = new Employee("E101", "Shlok", "Manager", 5000);
        Employee e2 = new Employee("E102", "Rahul", "Developer", 4000);
        Employee e3 = new Employee("E103", "Ananya", "Designer", 3500);
        Employee e4 = new Employee("E104", "Aman", "Intern", 2000);

        // Add to payroll
        payroll.addEmployee(e1);
        payroll.addEmployee(e2);
        payroll.addEmployee(e3);
        payroll.addEmployee(e4);

        System.out.println("\n--- Calculating Salaries ---");
        payroll.calculateAllSalaries();

        // Apply deduction to one employee
        System.out.println("\n--- Applying Deduction ---");
        Employee emp = payroll.findEmployeeById("E102");

        if (emp != null) {
            emp.applyDeduction(300);
            emp.displayEmployeeDetails();
        } else {
            System.out.println("Employee not found.");
        }
    }
}
