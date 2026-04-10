import java.util.HashMap;
import java.util.Map;

public class Word {
    public static void main(String[] args) {
        String text = "This is a test test paragraph with repeated repeated words";
        String[] words = text.split(" ");

        Map<String, Integer> count = new HashMap<>();
        for (String w : words) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }

        for (String w : count.keySet()) {
            if (count.get(w) > 1) {
                System.out.println(w);
            }
        }
    }
}