import java.util.*;

public class Login {

    public static void main(String[] args) throws InterruptedException {

        int totalUsers = 100;
        int batchSize = 10;

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < batchSize; i++) {
            Thread t = new Thread(new LoginTask(totalUsers / batchSize), "Login-Thread-" + (i + 1));
            threads.add(t);
        }

        for (Thread t : threads) {
            System.out.println(t.getName() + " state before start: " + t.getState());
            t.start();
        }

        for (Thread t : threads) {
            t.join();
            System.out.println(t.getName() + " state after execution: " + t.getState());
        }
    }
}

class LoginTask implements Runnable {

    private final int usersInBatch;

    public LoginTask(int usersInBatch) {
        this.usersInBatch = usersInBatch;
    }

    @Override
    public void run() {
        for (int i = 1; i <= usersInBatch; i++) {
            System.out.println(Thread.currentThread().getName() +
                    " - User " + i + " login started at " + new Date());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    " - User " + i + " login successful at " + new Date());
        }
    }
}
