import java.util.*;
public class Bankmanage {

    static HashMap<String, BankAccount> accounts = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

    case 1 -> createAccount();

    case 2 -> deposit();

    case 3 -> withdraw();

    case 4 -> checkBalance();

    case 5 -> {
        System.out.println("Thank you!");
        return;
    }

    default -> System.out.println("Invalid choice!");
}

        }
    }

    static void createAccount() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        System.out.print("1. Savings  2. Current : ");
        int type = sc.nextInt();

        if (type == 1) {
            accounts.put(accNo, new SavingsAccount(accNo, balance));
        } else {
            accounts.put(accNo, new CurrentAccount(accNo, balance));
        }

        System.out.println("Account created successfully.");
    }

    static void deposit() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();
        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        BankAccount acc = accounts.get(accNo);
        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    static void withdraw() {
        try {
            System.out.print("Enter Account Number: ");
            String accNo = sc.next();
            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            BankAccount acc = accounts.get(accNo);
            if (acc != null) {
                acc.withdraw(amount);
            } else {
                System.out.println("Account not found.");
            }
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    static void checkBalance() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        BankAccount acc = accounts.get(accNo);
        if (acc != null) {
            System.out.println("Balance: " + acc.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}



class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}


abstract class BankAccount {
    private double balance;
    private final  String  accountNumber;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited successfully.");
        }
    }

    public abstract void withdraw(double amount) throws InsufficientBalanceException;
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(String accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > getBalance()) {
            throw new InsufficientBalanceException("No overdraft allowed in Savings Account!");
        }
        setBalance(getBalance() - amount);
        System.out.println("Withdrawal successful.");
    }
}


class CurrentAccount extends BankAccount {

    public CurrentAccount(String accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (getBalance() - amount < -5000) {
            throw new InsufficientBalanceException("Overdraft limit exceeded!");
        }
        setBalance(getBalance() - amount);
        System.out.println("Withdrawal successful.");
    }
}

