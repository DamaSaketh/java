import java.util.*;
import java.util.stream.*;

public class Collector {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Raj", "Amit", "John");

        List<String> result = names.stream()
                .filter(name -> name.startsWith("J"))
                .collect(Collectors.toList());

        System.out.println(result);
    }
}