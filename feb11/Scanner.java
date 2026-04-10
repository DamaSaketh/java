public class Scanner {
    public static void main(String[] args) {
        LogScanner scannerThread = new LogScanner();
        scannerThread.start();

        for (int i = 0; i < 15; i++) {
            System.out.println("Thread State: " + scannerThread.getState());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}

class LogScanner extends Thread {
   
   @Override public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Scanning logs... Cycle " + i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
        }
    }
}
