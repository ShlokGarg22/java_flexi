import java.rmi.*;
import java.rmi.registry.*;

public class TempServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            TempImpl obj = new TempImpl();

            Naming.rebind("rmi://localhost/TempService", obj);

            System.out.println("Server ready (RMI registry started)");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}