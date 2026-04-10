import java.util.ArrayList;
import java.util.Collection;

public class fruit {
    public static void main(String[] args) {

        Collection<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        System.out.println("Fruits collection: " + fruits);

        fruits.remove("Banana");

        System.out.println("Size: " + fruits.size());

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}