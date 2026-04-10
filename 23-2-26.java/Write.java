import java.io.FileWriter;
import java.io.IOException;

public class Write{
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("sample.txt", false);

            writer.write("Line 1\n");
            writer.write("Line 2\n");
            writer.write("Line 3\n");
            writer.write("Line 4\n");
            writer.write("Line 5\n");

            writer.close();
            System.out.println("Data written successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}