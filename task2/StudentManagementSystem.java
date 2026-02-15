import java.util.ArrayList;

/**
 * StudentManagementSystem class handles CRUD operations for student records
 */
public class StudentManagementSystem {
    private ArrayList<Student> students;

    /**
     * Constructor - initializes the ArrayList
     */
    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    /**
     * Add a new student to the system
     */
    public void addStudent(Student student) {
        // Check if student with same ID already exists
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                System.out.println("Error: Student with ID " + student.getId() + " already exists!");
                return;
            }
        }
        students.add(student);
        System.out.println("Student added successfully!");
    }

    /**
     * View all students
     */
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found in the system.");
            return;
        }
        System.out.println("\n========== All Students ==========");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("==================================\n");
    }

    /**
     * View a specific student by ID
     */
    public Student searchStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    /**
     * Update student information by ID
     */
    public boolean updateStudent(int id, String newName, double newMarks) {
        Student student = searchStudentById(id);
        if (student != null) {
            student.setName(newName);
            student.setMarks(newMarks);
            System.out.println("Student updated successfully!");
            return true;
        }
        System.out.println("Error: Student with ID " + id + " not found!");
        return false;
    }

    /**
     * Delete a student by ID
     */
    public boolean deleteStudent(int id) {
        Student student = searchStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
            return true;
        }
        System.out.println("Error: Student with ID " + id + " not found!");
        return false;
    }

    /**
     * Get total number of students
     */
    public int getTotalStudents() {
        return students.size();
    }
}
