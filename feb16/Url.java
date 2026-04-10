public class Url {

    public static boolean validateUrl(String url) {
        if (url == null) {
            return false;
        }
        return url.startsWith("http://") || url.startsWith("https://");
    }

    public static void main(String[] args) {

        String[] urls = {
                "http://example.com",
                "https://secure.com",
                "ftp://file.com",
                "www.test.com",
                "https://openai.com"
        };

        for (String url : urls) {
            System.out.println(url + " -> " + (validateUrl(url) ? "Valid" : "Invalid"));
        }
    }
}
