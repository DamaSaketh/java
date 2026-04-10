public class Bank {
    public static void main(String[] args) {
        Account sharedAccount = new Account(1000);

        Customer c1 = new Customer(sharedAccount, "Customer1", 500);
        Customer c2 = new Customer(sharedAccount, "Customer2", 700);
        Customer c3 = new Customer(sharedAccount, "Customer3", 300);

        c1.start();
        c2.start();
        c3.start();
    }
}
class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }


    public synchronized void withdraw(String name, int amount) {
        if (balance >= amount) {
            System.out.println(name + " is withdrawing " + amount);
            balance -= amount;
            System.out.println("Remaining balance: " + balance);
        } else {
            System.out.println(name + " cannot withdraw " + amount + " (Insufficient Balance)");
        }
    }
}

class Customer extends Thread {
    private final Account account;
    private  final String customerName;
    private final  int amount;

    public Customer(Account account, String customerName, int amount) {
        this.account = account;
        this.customerName = customerName;
        this.amount = amount;
    }

    public void run() {
        account.withdraw(customerName, amount);
    }
}


