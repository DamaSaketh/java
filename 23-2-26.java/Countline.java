import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Countline {
    public static void main(String[] args) {
        int count = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("sample.txt"));
            @SuppressWarnings("unused")
            String line;

            while ((line = reader.readLine()) != null) {
                count++;
            }

            reader.close();
            System.out.println("Total number of lines: " + count);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}