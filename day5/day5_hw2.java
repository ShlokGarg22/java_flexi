//write a program in java where we will be using the abstract keyword to design a calculator application
abstract class BaseCalculator {
    abstract double calculate(double a, double b);
    abstract String getOperationName();

    void displayResult(double a, double b) {
        System.out.println("Operation: " + getOperationName());
        System.out.println("Input: " + a + " and " + b);
        System.out.println("Final Result: " + calculate(a, b));
        System.out.println("---------------------------------");
    }
}

class AddOperation extends BaseCalculator {
    double calculate(double a, double b) { return a + b; }
    String getOperationName() { return "Addition"; }
}

class SubtractOperation extends BaseCalculator {
    double calculate(double a, double b) { return a - b; }
    String getOperationName() { return "Subtraction"; }
}

class MultiplyOperation extends BaseCalculator {
    double calculate(double a, double b) { return a * b; }
    String getOperationName() { return "Multiplication"; }
}

public class day5_hw2 {
    public static void main(String[] args) {
        BaseCalculator add = new AddOperation();
        BaseCalculator sub = new SubtractOperation();
        BaseCalculator mul = new MultiplyOperation();

        add.displayResult(50, 10);
        sub.displayResult(50, 10);
        mul.displayResult(50, 10);
    }
}
