import java.util.*;
public class Cart {

    private final  List<Product> products = new ArrayList<>();

    public   final void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public final double calculateFinalTotal(DiscountStrategy strategy) {
        double total = calculateTotal();
        return strategy.applyDiscount(total);
    }

    public static void main(String[] args) {

        Cart cart = new Cart();

        cart.addProduct(new Electronics("Laptop", 50000));
        cart.addProduct(new Clothing("Shirt", 1500));
        cart.addProduct(new Groceries("Rice", 800));

        double total = cart.calculateTotal();
        System.out.println("Total Price: " + total);

        DiscountStrategy discount = new PercentageDiscount(10);
        double finalTotal = cart.calculateFinalTotal(discount);

        System.out.println("Final Price after 10% discount: " + finalTotal);
    }
}

interface Product {
    String getName();
    double getPrice();
}


class Electronics implements Product {
    private final String name;
    private final  double price;

    public Electronics(String name, double price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public String getName() { return name; }
    @Override    
    public double getPrice() { return price; }
}

class Clothing implements Product {
    
    private final  String name;
    private final  double price;

    public Clothing(String name, double price) {
        this.name = name;
        this.price = price;
    }
@Override
    public String getName() { return name; }
    @Override
    public double getPrice() { return price; }
}


class Groceries implements Product {
    private final  String  name;
    private final  double price;

    public Groceries(String name, double price) {
        this.name = name;
        this.price = price;
    }
@Override
    public String getName() { return name; }
    @Override
    public double getPrice() { return price; }
}


interface DiscountStrategy {
    double applyDiscount(double total);
}

class PercentageDiscount implements DiscountStrategy {
    private  final double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }
@Override
    public double applyDiscount(double total) {
        return total - (total * percent / 100);
    }
}


