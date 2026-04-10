public class Invent {
    public static void main(String[] args) {
        Inventory inventory = new Inventory(100);

        Worker w1 = new Worker(inventory, "Worker1", 40);
        Worker w2 = new Worker(inventory, "Worker2", 70);
        Worker w3 = new Worker(inventory, "Worker3", 30);

        w1.start();
        w2.start();
        w3.start();
    }
}

class Inventory {
    private int stock;

    public Inventory(int stock) {
        this.stock = stock;
    }

    public void updateStock(String name, int quantity) {
        synchronized (this) {
            if (stock >= quantity) {
                stock -= quantity;
                System.out.println(name + " updated stock by removing " + quantity);
                System.out.println("Remaining stock: " + stock);
            } else {
                System.out.println(name + " cannot remove " + quantity + " (Insufficient Stock)");
            }
        }
        System.out.println("Log: " + name + " attempted to update stock.");
    }
}

class Worker extends Thread {
    private final Inventory inventory;
    private final String workerName;
    private final int quantity;

    public Worker(Inventory inventory, String workerName, int quantity) {
        this.inventory = inventory;
        this.workerName = workerName;
        this.quantity = quantity;
    }
@Override
    public void run() {
        inventory.updateStock(workerName, quantity);
    }
}
