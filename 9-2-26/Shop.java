import java.util.ArrayList;

class Shop {
    String name;
    double price;

    
    Shop(String name, double price) {
        this.name = name;
        this.price = price;
    }




    public static void main(String[] args) {

        ArrayList<Shop> products = new ArrayList<>();

        products.add(new Shop("Laptop", 50000));
        products.add(new Shop("Mouse", 500));
        products.add(new Shop("Keyboard", 1500));

        double total = 0;

        System.out.println("Product Details:");
        for (Shop p : products) {
            System.out.println(p.name + " - " + p.price);
            total += p.price;
        }

        System.out.println("\nTotal Bill: " + total);
    }
}