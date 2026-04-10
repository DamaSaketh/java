import java.util.concurrent.*;


class Order {
    private final int orderId;

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order-" + orderId;
    }
}

class Producer implements Runnable {
    private final BlockingQueue<Order> queue;

    public Producer(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                Order order = new Order(i);
                queue.put(order);
                System.out.println("Produced: " + order);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer {
    private final BlockingQueue<Order> queue;
    private final ExecutorService executor;

    public Consumer(BlockingQueue<Order> queue) {
        this.queue = queue;
        this.executor = Executors.newFixedThreadPool(3);
    }

    public void start() {
        Runnable task = () -> {
            try {
                while (true) {
                    Order order = queue.take();
                    executor.submit(() -> processOrder(order));
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        new Thread(task).start();
    }

    private void processOrder(Order order) {
        System.out.println("Processing " + order + " by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Completed " + order);
    }
}

public class Block {
    public static void main(String[] args) {

        BlockingQueue<Order> queue = new ArrayBlockingQueue<>(5);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread producerThread = new Thread(producer);
        producerThread.start();

        consumer.start();
    }
}
