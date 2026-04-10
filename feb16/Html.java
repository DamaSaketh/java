public class Html {
    public static void main(String[] args) {
        String html = "<h1>Hello</h1>";
        String text = html.replaceAll("<[^>]*>", "");
        System.out.println(text);
    }
}