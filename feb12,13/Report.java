import java.util.*;
import java.util.concurrent.*;

class ReportTask implements Callable<String> {

    private final int reportId;

    public ReportTask(int reportId) {
        this.reportId = reportId;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Generating Report-" + reportId + " by " + Thread.currentThread().getName());
        Thread.sleep(2000);
        return "Report-" + reportId + " generated successfully";
    }
}

public class Report {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            tasks.add(new ReportTask(i));
        }

        try {
            List<Future<String>> results = executor.invokeAll(tasks);

            System.out.println("\n----- Report Summary -----");

            for (Future<String> future : results) {
                System.out.println(future.get());
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
