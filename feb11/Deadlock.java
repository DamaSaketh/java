public class Deadlock {
    public static void main(String[] args) {
        Account accountA = new Account("AccountA");
        Account accountB = new Account("AccountB");

        Thread t1 = new Thread(() -> {
            synchronized (accountA) {
                System.out.println("Thread1 locked " + accountA.name);
                try { Thread.sleep(100); } catch (Exception e) {}
                synchronized (accountB) {
                    System.out.println("Thread1 locked " + accountB.name);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (accountB) {
                System.out.println("Thread2 locked " + accountB.name);
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (accountA) {
                    System.out.println("Thread2 locked " + accountA.name);
                }
            }
        });

        t1.start();
        t2.start();
    }
}

class Account {
    String name;

    Account(String name) {
        this.name = name;
    }
}
