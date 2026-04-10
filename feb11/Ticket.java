public class Ticket {
    public static void main(String[] args) {
        Booking booking = new Booking();

        User u1 = new User(booking, "User1");
        User u2 = new User(booking, "User2");
        User u3 = new User(booking, "User3");
        User u4 = new User(booking, "User4");
        User u5 = new User(booking, "User5");

        u1.start();
        u2.start();
        u3.start();
        u4.start();
        u5.start();
    }
}

class Booking {
    int tickets = 10;

    public void bookTicket(String name) {
        if (tickets > 0) {
            System.out.println(name + " is booking ticket");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            tickets--;
            System.out.println(name + " booked successfully. Remaining: " + tickets);
        } else {
            System.out.println(name + " could not book. No tickets left.");
        }
    }

    public synchronized void bookTicketSync(String name) {
        if (tickets > 0) {
            System.out.println(name + " is booking ticket");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            tickets--;
            System.out.println(name + " booked successfully. Remaining: " + tickets);
        } else {
            System.out.println(name + " could not book. No tickets left.");
        }
    }
}

class User extends Thread {
    Booking booking;
    String name;

    User(Booking booking, String name) {
        this.booking = booking;
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            booking.bookTicket(name);
        }
    }
}
