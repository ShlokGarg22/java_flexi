import java.sql.*;
import java.util.Scanner;

public class CustomerApp {

    // ===== Database Configuration =====
    private static final String URL = "jdbc:mysql://localhost:3306/sakila";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Add the connector JAR to classpath.");
            return;
        }

        while (true) {
            System.out.println("\n==== CUSTOMER MANAGEMENT ====");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Update Email");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> addCustomer();
                case 2 -> viewCustomers();
                case 3 -> updateCustomer();
                case 4 -> deleteCustomer();
                case 5 -> exitProgram();
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // ===== Utility Method: Get Connection =====
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // ===== CREATE =====
    private static void addCustomer() {

        System.out.print("First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        if (firstName.isBlank() || lastName.isBlank() || email.isBlank()) {
            System.out.println("Fields cannot be empty.");
            return;
        }

        String sql = "INSERT INTO customer (store_id, first_name, last_name, email, address_id, active, create_date) "
                   + "VALUES (1, ?, ?, ?, 1, 1, NOW())";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Customer added successfully.");
            else
                System.out.println("Insert failed.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ===== READ =====
    private static void viewCustomers() {

        String sql = "SELECT customer_id, first_name, last_name, email FROM customer LIMIT 10";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Customer List ---");

            while (rs.next()) {
                System.out.printf("%d | %s | %s | %s%n",
                        rs.getInt("customer_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ===== UPDATE =====
    private static void updateCustomer() {

        System.out.print("Customer ID: ");
        int id = readInt();

        System.out.print("New Email: ");
        String newEmail = sc.nextLine();

        String sql = "UPDATE customer SET email=? WHERE customer_id=?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newEmail);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Customer updated.");
            else
                System.out.println("Customer not found.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ===== DELETE =====
    private static void deleteCustomer() {

        System.out.print("Customer ID: ");
        int id = readInt();

        String sql = "DELETE FROM customer WHERE customer_id=?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Customer deleted.");
            else
                System.out.println("Customer not found.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ===== Helper Method =====
    private static int readInt() {
        while (!sc.hasNextInt()) {
            System.out.println("Enter valid number.");
            sc.next();
        }
        int num = sc.nextInt();
        sc.nextLine(); // consume leftover newline
        return num;
    }

    private static void exitProgram() {
        System.out.println("Exiting...");
        sc.close();
        System.exit(0);
    }
}