import java.io.File;
import java.io.IOException;

public class sample{
    public static void main(String[] args) {
        try {
            File file = new File("sample.txt");

            if (file.exists()) {
                System.out.println("File already exists.");
            } else {
                if (file.createNewFile()) {
                    System.out.println("File created successfully.");
                } else {
                    System.out.println("File creation failed.");
                }
            }

            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("File Size: " + file.length() + " bytes");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}