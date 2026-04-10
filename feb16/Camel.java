public class Camel {
    public static void main(String[] args) {
        String sentence = "java string programs";
        String[] words = sentence.split(" ");
        String camel = words[0];
        for (int i = 1; i < words.length; i++) {
            camel += words[i].substring(0,1).toUpperCase() + words[i].substring(1);
        }
        System.out.println(camel);
    }
}