import java.util.concurrent.*;

public class Load {

    public static void main(String[] args) {

        int totalRequests = 100;
        int poolSize = 10;

        ExecutorService executor = Executors.newFixedThreadPool(poolSize);

        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= totalRequests; i++) {
            final int requestId = i;

            executor.submit(() -> {
                try {
                    System.out.println("Processing Request-" + requestId +
                            " by " + Thread.currentThread().getName());
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("\n----- Performance Summary -----");
        System.out.println("Total Requests: " + totalRequests);
        System.out.println("Thread Pool Size: " + poolSize);
        System.out.println("Total Time Taken: " + totalTime + " ms");
    }
}
