public class Order {
    public static void main(String[] args) {
        System.out.println("Order is being processed...");

        EmailThread email = new EmailThread("customer@example.com");
        email.start();

        System.out.println("Order confirmed successfully.");
    }
}

class EmailThread extends Thread {
    String email;

    EmailThread(String email) {
        this.email = email;
    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("Confirmation email sent to " + email);
    }
}
