import java.util.Random;

public class Gateway {
    public static void main(String[] args) {
        Payment p1 = new Payment("Payment1");
        Payment p2 = new Payment("Payment2");
        Payment p3 = new Payment("Payment3");

        p1.start();
        p2.start();
        p3.start();
    }
}

class Payment extends Thread {
    String paymentName;
    Random random = new Random();

    Payment(String paymentName) {
        this.paymentName = paymentName;
    }
@Override
    public void run() {
        int time = random.nextInt(3) + 1;
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
        }
        System.out.println(paymentName + " completed after " + time + " seconds");
    }
}
