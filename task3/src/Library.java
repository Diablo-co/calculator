import java.util.ArrayList;
import java.util.List;

/**
 * Library class manages books and users
 */
public class Library {
    private String libraryName;
    private List<Book> books;
    private List<User> users;

    /**
     * Constructor to initialize a Library
     * @param libraryName The name of the library
     */
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Getters and Setters
    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    /**
     * Add a book to the library
     * @param book The book to add
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("✓ Book added: " + book.getTitle());
    }

    /**
     * Add a user to the library
     * @param user The user to register
     */
    public void registerUser(User user) {
        users.add(user);
        System.out.println("✓ User registered: " + user.getName());
    }

    /**
     * Issue a book to a user
     * @param userId The ID of the user
     * @param isbn The ISBN of the book
     * @return true if book was issued successfully, false otherwise
     */
    public boolean issueBook(String userId, String isbn) {
        User user = findUserById(userId);
        Book book = findBookByIsbn(isbn);

        if (user == null) {
            System.out.println("✗ Error: User not found (ID: " + userId + ")");
            return false;
        }

        if (book == null) {
            System.out.println("✗ Error: Book not found (ISBN: " + isbn + ")");
            return false;
        }

        if (!book.isAvailable()) {
            System.out.println("✗ Error: Book is not available - '" + book.getTitle() + "' is already issued");
            return false;
        }

        user.issueBook(book);
        book.setAvailable(false);
        System.out.println("✓ Book issued successfully!");
        System.out.println("  Book: " + book.getTitle() + " → User: " + user.getName());
        return true;
    }

    /**
     * Return a book from a user
     * @param userId The ID of the user
     * @param isbn The ISBN of the book
     * @return true if book was returned successfully, false otherwise
     */
    public boolean returnBook(String userId, String isbn) {
        User user = findUserById(userId);
        Book book = findBookByIsbn(isbn);

        if (user == null) {
            System.out.println("✗ Error: User not found (ID: " + userId + ")");
            return false;
        }

        if (book == null) {
            System.out.println("✗ Error: Book not found (ISBN: " + isbn + ")");
            return false;
        }

        if (!user.returnBook(book)) {
            System.out.println("✗ Error: This book is not issued to this user");
            return false;
        }

        book.setAvailable(true);
        System.out.println("✓ Book returned successfully!");
        System.out.println("  Book: " + book.getTitle() + " ← User: " + user.getName());
        return true;
    }

    /**
     * Find a book by ISBN
     * @param isbn The ISBN of the book
     * @return The Book object if found, null otherwise
     */
    private Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Find a user by user ID
     * @param userId The user ID
     * @return The User object if found, null otherwise
     */
    private User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Display all available books
     */
    public void displayAvailableBooks() {
        System.out.println("\n--- Available Books ---");
        boolean found = false;
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println("  " + book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("  No available books at the moment");
        }
    }

    /**
     * Display all issued books
     */
    public void displayIssuedBooks() {
        System.out.println("\n--- Issued Books ---");
        boolean found = false;
        for (Book book : books) {
            if (!book.isAvailable()) {
                System.out.println("  " + book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("  No issued books at the moment");
        }
    }

    /**
     * Display all users and their issued books
     */
    public void displayAllUsers() {
        System.out.println("\n--- Registered Users ---");
        if (users.isEmpty()) {
            System.out.println("  No users registered");
            return;
        }
        for (User user : users) {
            System.out.println("  " + user);
            if (!user.getIssuedBooks().isEmpty()) {
                System.out.println("    Issued Books:");
                for (Book book : user.getIssuedBooks()) {
                    System.out.println("      - " + book.getTitle() + " (ISBN: " + book.getIsbn() + ")");
                }
            }
        }
    }

    /**
     * Display library statistics
     */
    public void displayLibraryStats() {
        int totalBooks = books.size();
        int availableBooks = 0;
        int issuedBooks = 0;

        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks++;
            } else {
                issuedBooks++;
            }
        }

        System.out.println("\n========== Library Statistics ==========");
        System.out.println("Library: " + libraryName);
        System.out.println("Total Books: " + totalBooks);
        System.out.println("Available Books: " + availableBooks);
        System.out.println("Issued Books: " + issuedBooks);
        System.out.println("Total Registered Users: " + users.size());
        System.out.println("=========================================");
    }
}
