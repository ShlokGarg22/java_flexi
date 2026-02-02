//wrute a program where you will be using final class and final method and feinal variable  within a sinegle program

final class SecurityManager {
    void authenticate() {
        System.out.println("User authenticated via SecurityManager.");
    }
}

class DatabaseConfig {
    final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    
    final void connect() {
        System.out.println("Connecting to: " + DB_URL);
        System.out.println("Connection established securely.");
    }
}

public class day5_hw3 extends DatabaseConfig {
    // Note: If we tried to override connect() here, it would throw a compilation error.
    
    public static void main(String[] args) {
        day5_hw3 app = new day5_hw3();
        
        System.out.println("Database endpoint: " + app.DB_URL);
        
        System.out.println("\n--- Initiating Connection ---");
        app.connect(); // Calling final method from parent
        
        System.out.println("\n--- Security Check ---");
        SecurityManager sm = new SecurityManager();
        sm.authenticate();
        
        System.out.println("\nApplication is now running.");
    }
}
