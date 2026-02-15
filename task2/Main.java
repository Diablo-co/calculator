import java.util.Scanner;

/**
 * Main class - CLI menu for Student Management System
 */
public class Main {
    private static StudentManagementSystem system;
    private static Scanner scanner;

    public static void main(String[] args) {
        system = new StudentManagementSystem();
        scanner = new Scanner(System.in);
        
        displayWelcome();
        
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getInput();
            
            switch (choice) {
                case 1:
                    addStudentMenu();
                    break;
                case 2:
                    system.viewAllStudents();
                    break;
                case 3:
                    searchStudentMenu();
                    break;
                case 4:
                    updateStudentMenu();
                    break;
                case 5:
                    deleteStudentMenu();
                    break;
                case 6:
                    running = false;
                    System.out.println("\nThank you for using Student Management System!");
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        
        scanner.close();
    }

    /**
     * Display welcome message
     */
    private static void displayWelcome() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║  Student Management System - v1.0    ║");
        System.out.println("║  CLI-based CRUD Application          ║");
        System.out.println("╚══════════════════════════════════════╝\n");
    }

    /**
     * Display main menu
     */
    private static void displayMenu() {
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("          MAIN MENU");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student (by ID)");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.print("Enter your choice (1-6): ");
    }

    /**
     * Menu for adding a new student
     */
    private static void addStudentMenu() {
        try {
            System.out.println("\n--- Add New Student ---");
            
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Student Marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            
            Student student = new Student(id, name, marks);
            system.addStudent(student);
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    /**
     * Menu for searching a student by ID
     */
    private static void searchStudentMenu() {
        try {
            System.out.println("\n--- Search Student ---");
            System.out.print("Enter Student ID to search: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            Student student = system.searchStudentById(id);
            if (student != null) {
                System.out.println("\n✓ Student Found:");
                System.out.println(student);
            } else {
                System.out.println("✗ Student with ID " + id + " not found!");
            }
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    /**
     * Menu for updating a student
     */
    private static void updateStudentMenu() {
        try {
            System.out.println("\n--- Update Student ---");
            System.out.print("Enter Student ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            Student student = system.searchStudentById(id);
            if (student == null) {
                System.out.println("✗ Student with ID " + id + " not found!");
                return;
            }
            
            System.out.println("Current Information: " + student);
            
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            
            System.out.print("Enter new marks: ");
            double newMarks = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            
            system.updateStudent(id, newName, newMarks);
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    /**
     * Menu for deleting a student
     */
    private static void deleteStudentMenu() {
        try {
            System.out.println("\n--- Delete Student ---");
            System.out.print("Enter Student ID to delete: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            Student student = system.searchStudentById(id);
            if (student != null) {
                System.out.println("Student to Delete: " + student);
                System.out.print("Are you sure? (yes/no): ");
                String confirmation = scanner.nextLine().toLowerCase();
                
                if (confirmation.equals("yes") || confirmation.equals("y")) {
                    system.deleteStudent(id);
                } else {
                    System.out.println("Deletion cancelled.");
                }
            } else {
                System.out.println("✗ Student with ID " + id + " not found!");
            }
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    /**
     * Get user input
     */
    private static int getInput() {
        try {
            int input = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            return input;
        } catch (Exception e) {
            scanner.nextLine(); // Clear invalid input
            return -1;
        }
    }
}
