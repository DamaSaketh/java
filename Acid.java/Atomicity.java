import java.sql.*;

public class Atomicity {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bankdb";
        String user = "root";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected");

            conn.setAutoCommit(false);

            PreparedStatement withdraw = conn.prepareStatement(
                    "UPDATE account SET balance = balance - ? WHERE id = ?");
            withdraw.setDouble(1, 1000);
            withdraw.setInt(2, 1);
            withdraw.executeUpdate();

            // int error = 10 / 0;

            conn.commit();
            System.out.println("Transaction Successful");

        } catch (Exception e) {
            System.out.println("Transaction Failed and Rolled Back");
            e.printStackTrace();
        }
    }
}