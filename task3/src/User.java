import java.util.ArrayList;
import java.util.List;

/**
 * User class represents a library member
 */
public class User {
    private String userId;
    private String name;
    private String email;
    private List<Book> issuedBooks;

    /**
     * Constructor to initialize a User
     * @param userId The unique identifier for the user
     * @param name The name of the user
     * @param email The email of the user
     */
    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.issuedBooks = new ArrayList<>();
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    /**
     * Add a book to the user's issued books list
     * @param book The book to issue
     */
    public void issueBook(Book book) {
        issuedBooks.add(book);
    }

    /**
     * Remove a book from the user's issued books list
     * @param book The book to return
     * @return true if book was removed, false otherwise
     */
    public boolean returnBook(Book book) {
        return issuedBooks.remove(book);
    }

    /**
     * Get the number of books currently issued to this user
     * @return The count of issued books
     */
    public int getIssuedBookCount() {
        return issuedBooks.size();
    }

    /**
     * Display user information
     */
    @Override
    public String toString() {
        return "User{" +
                "UserID='" + userId + '\'' +
                ", Name='" + name + '\'' +
                ", Email='" + email + '\'' +
                ", IssuedBooks=" + issuedBooks.size() +
                '}';
    }
}
