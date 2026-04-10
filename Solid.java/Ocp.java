
interface Notification {
    void send();
}

class EmailNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending Email...");
    }
}

class SMSNotification implements Notification {
   
   @Override
    public void send() {
        System.out.println("Sending SMS...");
    }
}

class NotificationService {
    public void sendNotification(Notification notification) {
        notification.send();
    }
}

class WhatsAppNotification implements Notification {
   @Override
    public void send() {
        System.out.println("Sending WhatsApp message...");
    }
}

public class Ocp {
    public static void main(String[] args) {

        NotificationService service = new NotificationService();

        Notification email = new EmailNotification();
        Notification sms = new SMSNotification();
        Notification whatsapp = new WhatsAppNotification();

        service.sendNotification(email);
        service.sendNotification(sms);
        service.sendNotification(whatsapp);
    }
}