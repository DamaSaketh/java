import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Countword{
    public static void main(String[] args) {
        int wordCount = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("sample.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                wordCount += words.length;
            }

            reader.close();
            System.out.println("Total number of words: " + wordCount);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}