import java.util.*;
public class movie {
    public static void main(String[] args) {

        Movie movie = new Movie("Avengers", 5); // Limited seats = 5

        User user1 = new User(movie, "Alice", 2);
        User user2 = new User(movie, "Bob", 3);
        User user3 = new User(movie, "Charlie", 2);

        user1.start();
        user2.start();
        user3.start();

        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Booking History:");
        for (String record : movie.getBookingHistory()) {
            System.out.println(record);
        }
    }
}

class Movie {
    private String movieName;
    private int totalSeats;
    private int availableSeats;
    private List<String> bookingHistory;

    public Movie(String movieName, int totalSeats) {
        this.movieName = movieName;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.bookingHistory = new ArrayList<>();
    }

    public String getMovieName() {
        return movieName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public List<String> getBookingHistory() {
        return bookingHistory;
    }

    
    public synchronized void bookTicket(String userName, int seatsRequested) {
        System.out.println(userName + " is trying to book " + seatsRequested + " seat(s).");

        if (seatsRequested <= availableSeats) {
            availableSeats -= seatsRequested;
            bookingHistory.add(userName + " booked " + seatsRequested + " seat(s)");
            System.out.println("Booking successful for " + userName);
            System.out.println("Seats remaining: " + availableSeats);
        } else {
            System.out.println("Booking failed for " + userName + " (Not enough seats)");
        }
        System.out.println();
    }
}

class User extends Thread {
    private Movie movie;
    private String userName;
    private int seatsToBook;

    public User(Movie movie, String userName, int seatsToBook) {
        this.movie = movie;
        this.userName = userName;
        this.seatsToBook = seatsToBook;
    }

    @Override
    public void run() {
        movie.bookTicket(userName, seatsToBook);
    }
}
