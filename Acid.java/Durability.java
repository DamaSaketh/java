import java.sql.*;

public class Durability {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bankdb";
        String user = "root";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            conn.setAutoCommit(false);

            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE account SET balance = balance + ? WHERE id = ?");
            ps.setDouble(1, 1000);
            ps.setInt(2, 1);
            ps.executeUpdate();

            conn.commit();
            System.out.println("Transaction Committed Successfully");

        } catch (Exception e) {
            System.out.println("Transaction Failed");
            e.printStackTrace();
        }
    }
}