import java.util.concurrent.*;

public class Job {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable cleanupTask = new Runnable() {
            int count = 0;
            public void run() {
                count++;
                System.out.println("Cleaning temporary files... cycle " + count);
                if (count >= 3) {
                    scheduler.shutdown();
                }
            }
        };

        scheduler.scheduleAtFixedRate(cleanupTask, 0, 5, TimeUnit.SECONDS);
    }
}
