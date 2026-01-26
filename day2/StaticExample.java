// Demonstrates the use of static methods and static variables in Java
public class StaticExample {
    // Static variable
    static int count = 0;

    // Static method
    static void incrementCount() {
        count++;
        System.out.println("Count after increment: " + count);
    }

    public static void main(String[] args) {
        // Accessing static method and variable without creating an object
        StaticExample.incrementCount();
        StaticExample.incrementCount();
    }
}