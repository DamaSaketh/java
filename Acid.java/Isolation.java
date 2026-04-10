import java.sql.*;

public class Isolation {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bankdb";
        String user = "root";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            PreparedStatement ps1 = conn.prepareStatement(
                    "SELECT balance FROM account WHERE id = ?");
            ps1.setInt(1, 1);
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");
                System.out.println("Balance Read: " + balance);
            }

            PreparedStatement ps2 = conn.prepareStatement(
                    "UPDATE account SET balance = balance + ? WHERE id = ?");
            ps2.setDouble(1, 500);
            ps2.setInt(2, 1);
            ps2.executeUpdate();

            conn.commit();
            System.out.println("Transaction Completed with SERIALIZABLE Isolation");

        } catch (Exception e) {
            System.out.println("Transaction Failed");
            e.printStackTrace();
        }
    }
}