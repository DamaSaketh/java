import java.util.concurrent.*;

class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(String user, double amount) {
        System.out.println(user + " attempting deposit: " + amount);
        balance += amount;
        System.out.println(user + " deposit successful. Current Balance: " + balance);
    }

    public synchronized void withdraw(String user, double amount) {
        System.out.println(user + " attempting withdrawal: " + amount);

        if (balance >= amount) {
            balance -= amount;
            System.out.println(user + " withdrawal successful. Current Balance: " + balance);
        } else {
            System.out.println(user + " withdrawal failed. Insufficient balance. Current Balance: " + balance);
        }
    }

    public synchronized double getBalance() {
        return balance;
    }
}

public class Atm {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(1000);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            final int userId = i;

            executor.submit(() -> {
                String user = "User-" + userId;

                account.withdraw(user, 300);
                account.deposit(user, 150);
                account.withdraw(user, 200);

                System.out.println(user + " completed transactions.\n");
            });
        }

        executor.shutdown();
    }
}
