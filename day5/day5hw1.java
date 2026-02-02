// write a program in java to implement interface to solve the diamonnd  problem
interface Printable {
    default void log() {
        System.out.println("Logging from Printable interface...");
    }
}

interface Savable {
    default void log() {
        System.out.println("Logging from Savable interface...");
    }
}

public class day5hw1 implements Printable, Savable {
    // Overriding is mandatory here because of the diamond problem
    @Override
    public void log() {
        System.out.println("--- Resolving the Diamond Problem in day5hw1 ---");
        Printable.super.log(); // Calling Printable's default method
        Savable.super.log();   // Calling Savable's default method
        System.out.println("Combined logs completed in the main class.");
    }

    public static void main(String[] args) {
        day5hw1 document = new day5hw1();
        document.log();
    }
}
