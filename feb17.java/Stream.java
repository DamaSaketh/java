import java.util.*;

public class Stream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        numbers.stream()
               .filter(n -> n > 20)
               .map(n -> n * 2)
               .forEach(System.out::println);
    }
}