import java.util.*;
import java.util.concurrent.*;

public class Batch {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(3);
        List<Future<Double>> results = new ArrayList<>();

        Account[] accounts = {
            new Account("A001", 1000, 5),
            new Account("A002", 2000, 4),
            new Account("A003", 1500, 6)
        };

        for (Account acc : accounts) {
            results.add(service.submit(new InterestCalculator(acc)));
        }

        for (Future<Double> f : results) {
            System.out.println("Calculated Interest: " + f.get());
        }

        service.shutdown();
    }
}

class Account {
    String id;
    double principal;
    double rate;

    Account(String id, double principal, double rate) {
        this.id = id;
        this.principal = principal;
        this.rate = rate;
    }
}

class InterestCalculator implements Callable<Double> {
    Account account;

    InterestCalculator(Account account) {
        this.account = account;
    }

    public Double call() {
        return account.principal * account.rate / 100;
    }
}
