import java.util.Scanner;

public class WrapperConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.in);
        
        System.out.print("Enter a float value: ");
        Float floatVal = scanner.nextFloat();
        
        int intVal = floatVal.intValue();
        
        System.out.println("Input Float value: " + floatVal);
        System.out.println("Printed as Integer: " + intVal);
        
        scanner.close();
    }
}
