import java.io.*;
import java.net.*;

public class TempServer {
    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server started... Waiting for client");

            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                double celsius = in.readDouble();

                if (celsius == -1) {
                    System.out.println("Server stopping...");
                    break;
                }

                double fahrenheit = (celsius * 9/5) + 32;
                out.writeDouble(fahrenheit);

                System.out.println("C: " + celsius + " → F: " + fahrenheit);
            }

            socket.close();
            server.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

