import java.io.*;

public class Copy{
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("source.txt"));
             FileWriter writer = new FileWriter("destination.txt")) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        }
    }
}