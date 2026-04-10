import java.util.concurrent.*;

public class Traffic {

    public static void main(String[] args) {

        int corePoolSize = 2;
        int maxPoolSize = 5;
        int queueCapacity = 3;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueCapacity),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 1; i <= 30; i++) {
            final int taskId = i;

            try {
                executor.execute(() -> {
                    System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());
                });

                System.out.println("Task " + taskId + " submitted");

            } catch (RejectedExecutionException e) {
                System.out.println("Task " + taskId + " rejected");
            }
        }

        executor.shutdown();
    }
}
