import java.util.*;

public class Foreach {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Raj", "Amit", "John");

        names.forEach(name -> System.out.println(name));

       
        names.forEach(System.out::println);
    }
}