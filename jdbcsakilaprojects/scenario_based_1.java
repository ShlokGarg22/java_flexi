import java.sql.*;
import java.util.Scanner;

public class DeleteStudentApp {

    // ===== Database Configuration =====
    private static final String URL = "jdbc:mysql://localhost:3306/CA3";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.print("Enter Roll Number to delete: ");
            int roll = sc.nextInt();

            String sql = "DELETE FROM Student WHERE roll_no=?";

            try (Connection conn = getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, roll);

                int rows = ps.executeUpdate();

                if (rows > 0)
                    System.out.println("Record deleted successfully.");
                else
                    System.out.println("Record not found.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    // ===== Get Connection =====
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}