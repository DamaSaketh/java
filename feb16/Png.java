public class Png {
    public static void main(String[] args) {
        String filename = "photo.png";
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex != -1 && dotIndex < filename.length() - 1) {
            String ext = filename.substring(dotIndex + 1);
            System.out.println(ext);
        } else {
            System.out.println("No extension");
        }
    }
}