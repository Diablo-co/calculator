/**
 * Main class to demonstrate the Library Management System
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========== Library Management System ==========\n");

        // Create a library
        Library library = new Library("City Central Library");

        // Add books to the library
        System.out.println("--- Adding Books to Library ---");
        library.addBook(new Book("978", "The C Programming Language", "Brian W. Kernighan"));
        library.addBook(new Book("978", "Head First Java", "Kathy Sierra"));
        library.addBook(new Book("978", "Clean Code", "Robert C. Martin"));
        library.addBook(new Book("97", "Design Patterns", "Gang of Four"));
        library.addBook(new Book("202212", "Learning JavaScript", "Ethan Brown"));

        // Register users
        System.out.println("\n--- Registering Users ---");
        User user1 = new User("U001", "Alice Johnson", "alice@email.com");
        User user2 = new User("U002", "Bob Smith", "bob@email.com");
        User user3 = new User("U003", "Charlie Brown", "charlie@email.com");

        library.registerUser(user1);
        library.registerUser(user2);
        library.registerUser(user3);

        // Display initial statistics
        library.displayLibraryStats();

        // Display available books
        library.displayAvailableBooks();

        // Issue books
        System.out.println("\n--- Issuing Books ---");
        library.issueBook("U001", "978");  // Alice issues Head First Java
        library.issueBook("U001", "978");  // Alice issues The C Programming Language
        library.issueBook("U002", "978");  // Bob issues Clean Code
        library.issueBook("U003", "97");   // Charlie issues Design Patterns

        // Try to issue a book that's already issued
        System.out.println("\n--- Attempting to Issue Already Issued Book ---");
        library.issueBook("U002", "978-0-596-00712-6");  // This should fail

        // Display available and issued books
        library.displayAvailableBooks();
        library.displayIssuedBooks();

        // Display all users with their issued books
        library.displayAllUsers();

        // Return some books
        System.out.println("\n--- Returning Books ---");
        library.returnBook("U001", "978"); // Alice returns The C Programming Language
        library.returnBook("U002", "978"); // Bob returns Clean Code

        // Try to return a book that's not issued by the user
        System.out.println("\n--- Attempting Invalid Return ---");
        library.returnBook("U003", "978-0-13-1 ");  // This should fail - Charlie didn't issue this

        // Display final statistics
        library.displayAvailableBooks();
        library.displayIssuedBooks();
        library.displayAllUsers();
        library.displayLibraryStats();

        System.out.println("\n========== End of Demonstration ==========");
    }
}
