import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class File {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            int fileId = i;
            service.submit(() -> {
                System.out.println("Processing file " + fileId + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                System.out.println("Completed file " + fileId);
            });
        }

        service.shutdown();
    }
}
