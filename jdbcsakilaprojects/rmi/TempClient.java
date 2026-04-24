import java.rmi.*;
import java.util.Scanner;

public class TempClient {
    public static void main(String[] args) {
        try {
            TempInterface obj = (TempInterface) Naming.lookup("rmi://localhost/TempService");

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.print("Enter Celsius (-1 to exit): ");
                double c = sc.nextDouble();

                if (c == -1) break;

                double f = obj.convert(c);
                System.out.println("Fahrenheit: " + f);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}