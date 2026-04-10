import java.util.*;

public class Inventory {

    public static void main(String[] args) {

        InventorySystem system = new InventorySystem();

        system.addProduct(new Product(1, "Laptop", 10));
        system.addProduct(new Product(2, "Mouse", 25));
        system.addProduct(new Product(3, "Keyboard", 15));

        system.updateProductStock(1, 5);
        system.updateProductStock(2, -30);

        system.searchProduct(1);
        system.searchProduct("Mouse");

        system.deleteProduct(3);

        system.generateStockReport();
    }
}

class Product {

    private  final int id;
    private final  String name;
    private  int stock;

    public Product(int id, String name, int stock) {
        this.id = id;
        this.name = name;
        if (stock >= 0) {
            this.stock = stock;
        } else {
            this.stock = 0;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void updateStock(int quantity) {
        if (stock + quantity >= 0) {
            stock += quantity;
            System.out.println("Stock updated. Current stock: " + stock);
        } else {
            System.out.println("Error: Stock cannot be negative.");
        }
    }
    @Override
    public String toString() {
        return id + " - " + name + " | Stock: " + stock;
    }
}

class InventorySystem {

    private final  List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added.");
    }

    public void updateProductStock(int id, int quantity) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.updateStock(quantity);
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void deleteProduct(int id) {
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getId() == id) {
                iterator.remove();
                System.out.println("Product deleted.");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public void searchProduct(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                System.out.println("Found: " + p);
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void searchProduct(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + p);
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void generateStockReport() {
        System.out.println("\nStock Report:");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
