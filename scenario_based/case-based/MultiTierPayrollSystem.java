class Employee {
    private String name;
    protected float baseSalary;

    public Employee(String name, float baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public float calculateSalary() {
        return baseSalary + (baseSalary * 0.05f);
    }
}

class Manager extends Employee {

    public Manager(String name, float baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public float calculateSalary() {
        return super.calculateSalary() + 2000f;
    }
}

class Executive extends Manager {

    public Executive(String name, float baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public float calculateSalary() {
        return super.calculateSalary() + (getBaseSalary() * 0.10f);
    }
}

public class MultiTierPayrollSystem {
    public static void main(String[] args) {
        Employee employee = new Employee("Alice", 10000f);
        Manager manager = new Manager("Bob", 10000f);
        Executive executive = new Executive("Charlie", 10000f);

        System.out.println("TC 1 - Employee (Alice): " + employee.calculateSalary());
        System.out.println("TC 2 - Manager (Bob): " + manager.calculateSalary());
        System.out.println("TC 3 - Executive (Charlie): " + executive.calculateSalary());

        Employee upcasted = new Executive("Diana", 10000f);
        System.out.println("Upcasting Demo (Employee ref -> Executive obj): "
                + upcasted.calculateSalary());
    }
}
