import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Log {
    public static void main(String[] args) {
        int errorCount = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("ERROR")) {
                    errorCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println("Number of ERROR lines: " + errorCount);
    }
}