import java.util.Scanner;

public class MethodsExample {
    
    public static void displayStatic(String data) {
        System.out.println("Static Method called with data: " + data);
    }
    
    public void displayInstance(String data) {
        System.out.println("Instance Method called with data: " + data);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.in);
        
        System.out.print("Enter some data for the static method: ");
        String staticData = scanner.nextLine();
        
        System.out.print("Enter some data for the instance method: ");
        String instanceData = scanner.nextLine();
        
        // Calling static method using class name
        MethodsExample.displayStatic(staticData);
        
        // Calling instance method using object
        MethodsExample obj = new MethodsExample();
        obj.displayInstance(instanceData);
        
        scanner.close();
    }
}
