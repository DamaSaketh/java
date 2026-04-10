import java.util.*;

public class Library {

    public static void main(String[] args) {

        LibrarySystem library = new LibrarySystem();

        library.addBook(new Book(1, "Java Programming", "James Gosling"));
        library.addBook(new Book(2, "Data Structures", "Mark Allen"));
        library.addBook(new Book(3, "Operating Systems", "Andrew Tanenbaum"));

        Member member1 = new Member(101, "Alice");

        try {
            library.issueBook(1, member1);
            library.issueBook(1, member1);
        } catch (BookUnavailableException e) {
            System.out.println(e.getMessage());
        }

        library.returnBook(1);

        System.out.println("\nSorted by Title:");
        library.sortByTitle();

        System.out.println("\nSorted by Author:");
        library.sortByAuthor();
    }
}

class Book {

    private final int id;
    private final String title;
    private final String author;
    private  boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issue() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }
    @Override
    public String toString() {
            
        return id + " - " + title + " by " + author +
                (isIssued ? " (Issued)" : " (Available)");
    }
}

class Member {

    private final  int memberId;

    private final String name;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }
}

class BookUnavailableException extends Exception {

    public BookUnavailableException(String message) {
        super(message);
    }
}

class LibrarySystem {

    private final  List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void issueBook(int bookId, Member member)
            throws BookUnavailableException {

        for (Book b : books) {
            if (b.getId() == bookId) {

                if (b.isIssued()) {
                    throw new BookUnavailableException("Book is already issued!");
                }

                b.issue();
                System.out.println("Book issued to " + member.getName());
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void returnBook(int bookId) {

        for (Book b : books) {
            if (b.getId() == bookId) {

                if (!b.isIssued()) {
                    System.out.println("Book was not issued.");
                } else {
                    b.returnBook();
                    System.out.println("Book returned successfully.");
                }
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void sortByTitle() {
        books.sort(Comparator.comparing(Book::getTitle));
        displayBooks();
    }

    public void sortByAuthor() {
        books.sort(Comparator.comparing(Book::getAuthor));
        displayBooks();
    }

    private void displayBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }
}
