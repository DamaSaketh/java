import java.io.FileWriter;
import java.io.IOException;

public class Append{
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("sample.txt", true);

            writer.write("New appended line\n");

            writer.close();
            System.out.println("Data appended successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}