import java.util.*;

public class Method {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("A", "B", "C");

        list.forEach(System.out::println);
    }
}