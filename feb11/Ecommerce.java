public class Ecommerce {

    public static void main(String[] args) {

        Thread[] orders = new Thread[5];

        for (int i = 0; i < 5; i++) {
            Order order = new Order(i + 1);
            Thread t = new Thread(order, "Order-Thread-" + (i + 1));
            orders[i] = t;
            t.start();
        }

        for (Thread t : orders) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All orders processed successfully.");
    }
}

class Order implements Runnable {

    private int orderId;

    public Order(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        validate();
        processPayment();
        System.out.println(Thread.currentThread().getName() +
                " - Order " + orderId + " completed.");
    }

    private void validate() {
        System.out.println(Thread.currentThread().getName() +
                " - Order " + orderId + " validation started.");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        System.out.println(Thread.currentThread().getName() +
                " - Order " + orderId + " validation completed.");
    }

    private void processPayment() {
        System.out.println(Thread.currentThread().getName() +
                " - Order " + orderId + " payment processing started.");
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        System.out.println(Thread.currentThread().getName() +
                " - Order " + orderId + " payment processed.");
    }
}
