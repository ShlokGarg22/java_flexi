import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TempClient {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Socket socket = new Socket("localhost", 5000);

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            while (true) {
                System.out.print("Enter Celsius (-1 to exit): ");
                double celsius = sc.nextDouble();

                out.writeDouble(celsius);

                // exit condition
                if (celsius == -1) {
                    System.out.println("Closing client...");
                    break;
                }

                double fahrenheit = in.readDouble();
                System.out.println("Fahrenheit: " + fahrenheit);
            }

            socket.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}