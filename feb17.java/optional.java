// Optional<T> is a container object introduced in Java 8 to avoid NullPointerException (NPE).

// It can either:

// Contain a value

// Or be empty
import java.util.*;

public class optional {
    public static void main(String[] args) {

        List<String> names =
                Arrays.asList("Raj", "Amit", "John");

        Optional<String> result =
                names.stream()
                     .filter(n -> n.startsWith("A"))
                     .findFirst();

        result.ifPresent(System.out::println);
    }
}