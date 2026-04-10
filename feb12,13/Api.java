import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Api {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 20; i++) {
            int requestId = i;
            service.submit(new ApiTask(requestId));
        }

        service.shutdown();
    }
}

class ApiTask implements Runnable {
    int requestId;

    ApiTask(int requestId) {
        this.requestId = requestId;
    }

    public void run() {
        System.out.println("Request " + requestId + " handled by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
