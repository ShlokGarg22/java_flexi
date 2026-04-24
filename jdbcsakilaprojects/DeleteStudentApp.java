import java.sql.*;
import java.util.Scanner;

public class DeleteStudentApp {

	private static final String URL = "jdbc:mysql://localhost:3306/CA3";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.print("Enter Roll Number to delete: ");
			int roll = sc.nextInt();


			try (Connection conn = getConnection()) {

				String selectSql = "SELECT name FROM Student WHERE roll_no=?";
				try (PreparedStatement selectPs = conn.prepareStatement(selectSql)) {
					selectPs.setInt(1, roll);
					ResultSet rs = selectPs.executeQuery();
					if (rs.next()) {
						String name = rs.getString("name");
						System.out.println("Removing student: " + name);


						String deleteSql = "DELETE FROM Student WHERE roll_no=?";
						try (PreparedStatement deletePs = conn.prepareStatement(deleteSql)) {
							deletePs.setInt(1, roll);
							int rows = deletePs.executeUpdate();
							if (rows > 0)
								System.out.println("Record deleted successfully.");
							else
								System.out.println("Record not found.");
						}
					} else {
						System.out.println("Record not found.");
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			sc.close();
		}
	}
	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}

