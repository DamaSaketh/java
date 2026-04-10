import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter word to search: ");
        String searchWord = scanner.nextLine();

        int lineNumber = 0;
        boolean found = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("sample.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.contains(searchWord)) {
                    System.out.println("Word found at line: " + lineNumber);
                    found = true;
                }
            }

            reader.close();

            if (!found) {
                System.out.println("Word not found in file.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        scanner.close();
    }
}