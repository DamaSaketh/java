import java.util.Random;
import java.util.Scanner;

public class Otp {
    public static void main(String[] args) {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        System.out.println("Your OTP is: " + otp);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter OTP: ");
        int entered = scanner.nextInt();

        if (entered == otp) {
            System.out.println("OTP Verified Successfully!");
        } else {
            System.out.println("Invalid OTP. Verification Failed.");
        }
        scanner.close();
    }
}