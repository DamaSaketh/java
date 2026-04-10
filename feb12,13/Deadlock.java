import java.util.concurrent.locks.ReentrantLock;

class Inventory {
    private final ReentrantLock lock = new ReentrantLock();

    public ReentrantLock getLock() {
        return lock;
    }

    public void reserveItem(String user) {
        System.out.println(user + " reserved inventory");
    }
}

class Payment {
    private final ReentrantLock lock = new ReentrantLock();

    public ReentrantLock getLock() {
        return lock;
    }

    public void processPayment(String user) {
        System.out.println(user + " payment processed");
    }
}

class OrderService {

    private final Inventory inventory;
    private final Payment payment;

    public OrderService(Inventory inventory, Payment payment) {
        this.inventory = inventory;
        this.payment = payment;
    }

    public void placeOrder(String user) {

        ReentrantLock firstLock;
        ReentrantLock secondLock;

        if (System.identityHashCode(inventory) < System.identityHashCode(payment)) {
            firstLock = inventory.getLock();
            secondLock = payment.getLock();
        } else {
            firstLock = payment.getLock();
            secondLock = inventory.getLock();
        }

        firstLock.lock();
        try {
            Thread.sleep(100);
            secondLock.lock();
            try {
                inventory.reserveItem(user);
                payment.processPayment(user);
                System.out.println(user + " order completed safely");
            } finally {
                secondLock.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            firstLock.unlock();
        }
    }
}

public class Deadlock {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        Payment payment = new Payment();
        OrderService service = new OrderService(inventory, payment);

        Runnable user1 = () -> service.placeOrder("User-1");
        Runnable user2 = () -> service.placeOrder("User-2");

        new Thread(user1).start();
        new Thread(user2).start();

        System.out.println("Deadlock prevented using consistent lock ordering");
    }
}
