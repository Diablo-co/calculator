# Student Management System - CLI Application

## Overview
This is a Java-based CLI (Command Line Interface) CRUD application for managing student records. The system allows users to add, view, search, update, and delete student records.

## Features
- ✅ **Add Student** - Add new student records with ID, name, and marks
- ✅ **View All Students** - Display all students in the system
- ✅ **Search Student** - Find a specific student by ID
- ✅ **Update Student** - Modify student information
- ✅ **Delete Student** - Remove student records with confirmation

## Project Structure

### Files
1. **Student.java** - Student model class with attributes and methods
   - Fields: id, name, marks
   - Includes getters, setters, and toString() method

2. **StudentManagementSystem.java** - Business logic layer
   - ArrayList to store student objects
   - Methods: addStudent(), viewAllStudents(), searchStudentById(), updateStudent(), deleteStudent()
   - Includes validation to prevent duplicate IDs

3. **Main.java** - CLI interface with user menu
   - Menu-driven system
   - Input validation and error handling
   - User-friendly interface with formatted output

## Compilation and Execution

### Prerequisites
- Java JDK (version 8 or higher)

### Compile
```bash
javac *.java
```
or
```bash
javac Student.java StudentManagementSystem.java Main.java
```

### Run
```bash
java Main
```

## How to Use

1. **Run the program** - Execute `java Main`
2. **Main Menu Options:**
   - Press `1` to Add a new student
   - Press `2` to View all students
   - Press `3` to Search for a student by ID
   - Press `4` to Update a student's information
   - Press `5` to Delete a student
   - Press `6` to Exit the program

### Example Usage:
```
1. Add Student
   - ID: 101
   - Name: John Doe
   - Marks: 85.5

2. View All Students
   - Shows: ID: 101 | Name: John Doe | Marks: 85.5

3. Search Student
   - Search by ID: 101
   - Displays student details

4. Update Student
   - ID: 101
   - New Name: John Smith
   - New Marks: 90.0

5. Delete Student
   - ID: 101
   - Confirms deletion before removing
```

## Features Explained

### Add Student
- Validates if student ID already exists
- Prevents duplicate records
- Stores student in ArrayList

### View All Students
- Displays all student records in a formatted table
- Shows message if no students exist

### Search Student
- Finds student by unique ID
- Returns student details or "not found" message

### Update Student
- Shows current student information
- Allows modification of name and marks
- Validates student exists before updating

### Delete Student
- Shows student details before deletion
- Requires confirmation (yes/no)
- Prevents accidental deletion

## Error Handling
- Invalid input validation
- Duplicate ID prevention
- Student not found handling
- Try-catch blocks for exception management

## Sample Test Data
Try adding these students for testing:
- ID: 101, Name: Alice Johnson, Marks: 92.5
- ID: 102, Name: Bob Smith, Marks: 87.0
- ID: 103, Name: Carol White, Marks: 95.5
- ID: 104, Name: Dave Brown, Marks: 78.5

## Notes
- All records are stored in memory (ArrayList)
- Data is cleared when the program exits
- Student ID is assumed to be unique
- Marks should be between 0 and 100

## Future Enhancements
- Add file persistence (save/load from database)
- Add sorting capabilities (by name, ID, marks)
- Add average marks calculation
- Add grade assignment
- Implement database integration
- Add search by name functionality
