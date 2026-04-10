public class report {

    public static void main(String[] args) {

        Thread salesReport = new Thread(new ReportTask("Sales Report", 2000));
        Thread inventoryReport = new Thread(new ReportTask("Inventory Report", 3000));
        Thread profitReport = new Thread(new ReportTask("Profit Report", 2500));

        salesReport.start();
        inventoryReport.start();
        profitReport.start();

        try {
            salesReport.join();
            inventoryReport.join();
            profitReport.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All reports completed");
    }
}

class ReportTask implements Runnable {

    private  final String reportName;
    private final int duration;

    public ReportTask(String reportName, int duration) {
        this.reportName = reportName;
        this.duration = duration;
    }

    @Override
    public void run() {
        System.out.println(reportName + " started.");
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(reportName + " completed.");
    }
}
