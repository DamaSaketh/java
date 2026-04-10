import java.util.*;

public class Payment {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter payment type (UPI / CreditCard / NetBanking): ");
        String type = sc.nextLine();

        System.out.println("Enter amount: ");
        double amount = sc.nextDouble();

        PaymentMethod payment = PaymentFactory.getPaymentMethod(type);

        if (payment != null) {
            payment.processPayment(amount);   
        } else {
            System.out.println("Invalid Payment Type!");
        }

        sc.close();
    }
}


interface PaymentMethod {
    void processPayment(double amount);
}
class UPIPayment implements PaymentMethod {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI Payment of ₹" + amount);
        System.out.println("UPI Payment Successful!");
    }
}

class CreditCardPayment implements PaymentMethod {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card Payment of ₹" + amount);
        System.out.println("Credit Card Payment Successful!");
    }
}

class NetBankingPayment implements PaymentMethod {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Net Banking Payment of ₹" + amount);
        System.out.println("Net Banking Payment Successful!");
    }
}

class PaymentFactory {

    public static PaymentMethod getPaymentMethod(String type) {

        if (type.equalsIgnoreCase("UPI")) {
            return new UPIPayment();
        } 
        else if (type.equalsIgnoreCase("CreditCard")) {
            return new CreditCardPayment();
        } 
        else if (type.equalsIgnoreCase("NetBanking")) {
            return new NetBankingPayment();
        } 
        else {
            return null;
        }
    }
}
