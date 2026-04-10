import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class check {
    public static void main(String[] args) {

        int a = 10, b = 0;

        
        try {
            Scanner sc = new Scanner(new File("test.txt")); 
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}