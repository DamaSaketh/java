import java.io.*;

public class Merge {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader("file1.txt"));
             BufferedReader reader2 = new BufferedReader(new FileReader("file2.txt"));
             FileWriter writer = new FileWriter("merged.txt")) {

            String line;

            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }

            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }

            System.out.println("Files merged successfully into merged.txt.");

        } catch (IOException e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        }
    }
}