import java.io.IOException;

public class Throw{

    static void checkNumber(int number) throws IOException {
        if (number < 0) {
            throw new IOException("Number cannot be negative");
        } else {
            System.out.println("Number is: " + number);
        }
    }

    public static void main(String[] args) {
        try {
            checkNumber(-5);
        } catch (IOException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}