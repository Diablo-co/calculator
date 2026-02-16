# Library Management System

A mini Java project to manage books and users in a library with features for book issuance and returns.

## Project Structure

```
task3/
├── src/
│   ├── Book.java         # Represents a book in the library
│   ├── User.java         # Represents a library member
│   ├── Library.java      # Manages books and users
│   └── Main.java         # Demonstration with sample data
├── bin/                  # Compiled class files (generated after compilation)
└── .vscode/
    └── tasks.json        # VS Code build and run tasks
```

## Classes Overview

### Book.java
- **Properties**: ISBN, Title, Author, Availability Status
- **Methods**: 
  - Getters and setters for all properties
  - `toString()` - Display book information

### User.java
- **Properties**: User ID, Name, Email, List of Issued Books
- **Methods**:
  - `issueBook(Book)` - Add a book to user's issued list
  - `returnBook(Book)` - Remove a book from user's issued list
  - `getIssuedBookCount()` - Get number of books issued to user
  - `toString()` - Display user information

### Library.java
- **Properties**: Library Name, Collection of Books, Collection of Users
- **Core Methods**:
  - `addBook(Book)` - Add a book to the library
  - `registerUser(User)` - Register a new user
  - `issueBook(userId, isbn)` - Issue a book to a user
  - `returnBook(userId, isbn)` - Return a book from a user
- **Display Methods**:
  - `displayAvailableBooks()` - Show all available books
  - `displayIssuedBooks()` - Show all issued books
  - `displayAllUsers()` - Show users and their issued books
  - `displayLibraryStats()` - Show library statistics

### Main.java
- Demonstrates the system with sample data and operations
- Creates a library with books and users
- Demonstrates book issuance and returns
- Shows error handling for invalid operations

## Features

✓ **Book Management** - Add books with ISBN, title, and author  
✓ **User Registration** - Register library members  
✓ **Book Issue** - Issue available books to users with validation  
✓ **Book Return** - Return books with error checking  
✓ **Availability Tracking** - Track book availability status  
✓ **User Book History** - Keep track of books issued to each user  
✓ **Library Statistics** - View total books, available, issued, and registered users  
✓ **Error Handling** - Comprehensive error messages for invalid operations  
 

## Sample Output

The program demonstrates:
1. Adding 5 books to the library
2. Registering 3 users
3. Issuing books to users (with validation)
4. Attempting to issue already-issued books (error handling)
5. Viewing available and issued books
6. Returning books
7. Attempting invalid returns (error handling)
8. Displaying final library statistics

## Error Handling

The system validates:
- User existence before issuing/returning books
- Book existence before any transaction
- Book availability before issuance
- Valid ownership before return (user must have issued the book)

All operations provide clear success and error messages with details.

## Extension Ideas

- Add book category/genre classification
- Implement due dates for book returns
- Add fine calculation for late returns
- Search books by title or author
- View reading history for users
- Implement book reservations
- Add database persistence
- Create a GUI interface

