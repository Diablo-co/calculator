import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NotesManager {
    private static final String NOTES_FILE = "notes.txt";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addNote();
                    break;
                case "2":
                    viewAllNotes();
                    break;
                case "3":
                    searchNote();
                    break;
                case "4":
                    deleteNote();
                    break;
                case "5":
                    System.out.println("Thank you for using Notes Manager. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n========== NOTES MANAGER ==========");
        System.out.println("1. Add a new note");
        System.out.println("2. View all notes");
        System.out.println("3. Search for a note");
        System.out.println("4. Delete a note");
        System.out.println("5. Exit");
        System.out.println("==================================");
    }

    private static void addNote() {
        System.out.print("Enter note title: ");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Title cannot be empty!\n");
            return;
        }

        System.out.print("Enter note content: ");
        String content = scanner.nextLine().trim();

        if (content.isEmpty()) {
            System.out.println("Content cannot be empty!\n");
            return;
        }

        String timestamp = LocalDateTime.now().format(formatter);
        String noteEntry = "\n[TITLE]: " + title + "\n[DATE]: " + timestamp + "\n[CONTENT]: " + content + "\n" + "=".repeat(50);

        try (FileWriter writer = new FileWriter(NOTES_FILE, true)) {
            writer.write(noteEntry);
            System.out.println("✓ Note added successfully!\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage() + "\n");
        }
    }

    private static void viewAllNotes() {
        File file = new File(NOTES_FILE);

        if (!file.exists()) {
            System.out.println("No notes found. Create one first!\n");
            return;
        }

        System.out.println("\n========== ALL NOTES ==========");
        try (BufferedReader reader = new BufferedReader(new FileReader(NOTES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("==============================\n");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage() + "\n");
        }
    }

    private static void searchNote() {
        System.out.print("Enter keyword to search: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        if (keyword.isEmpty()) {
            System.out.println("Search keyword cannot be empty!\n");
            return;
        }

        File file = new File(NOTES_FILE);

        if (!file.exists()) {
            System.out.println("No notes found.\n");
            return;
        }

        System.out.println("\n========== SEARCH RESULTS ==========");
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(NOTES_FILE))) {
            String line;
            StringBuilder currentNote = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                currentNote.append(line).append("\n");

                if (line.contains("=".repeat(50))) {
                    if (currentNote.toString().toLowerCase().contains(keyword)) {
                        System.out.println(currentNote.toString());
                        found = true;
                    }
                    currentNote = new StringBuilder();
                }
            }

            if (!found) {
                System.out.println("No notes found matching '" + keyword + "'.");
            }
            System.out.println("====================================\n");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage() + "\n");
        }
    }

    private static void deleteNote() {
        System.out.print("Enter the title of the note to delete: ");
        String titleToDelete = scanner.nextLine().trim();

        if (titleToDelete.isEmpty()) {
            System.out.println("Title cannot be empty!\n");
            return;
        }

        File file = new File(NOTES_FILE);

        if (!file.exists()) {
            System.out.println("No notes found.\n");
            return;
        }

        StringBuilder remainingNotes = new StringBuilder();
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(NOTES_FILE))) {
            String line;
            StringBuilder currentNote = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                currentNote.append(line).append("\n");

                if (line.contains("=".repeat(50))) {
                    if (!currentNote.toString().contains("[TITLE]: " + titleToDelete)) {
                        remainingNotes.append(currentNote.toString());
                    } else {
                        found = true;
                    }
                    currentNote = new StringBuilder();
                }
            }

            if (found) {
                try (FileWriter writer = new FileWriter(NOTES_FILE, false)) {
                    writer.write(remainingNotes.toString());
                    System.out.println("✓ Note deleted successfully!\n");
                }
            } else {
                System.out.println("Note with title '" + titleToDelete + "' not found.\n");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }
}
