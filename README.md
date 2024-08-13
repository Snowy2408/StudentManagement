
# Student Management System

This Java program allows users to manage student information, including adding, editing, deleting, sorting, and searching for students. It also includes a ranking system based on the provided marks criteria.

## Features

1. **Add Student**: Add a new student with ID, name, and marks.
2. **Edit Student**: Edit the details of an existing student.
3. **Delete Student**: Delete a student by ID.
4. **Sort Students by Marks**: Sort the list of students based on their marks in descending order.
5. **Search Student by ID**: Search for a student by their ID.
6. **Rank Students**: Display the students ranked by their marks.
7. **Display All Students**: Display the list of all students.

## Classes

### Student

Represents a student with the following attributes:
- `id`: The student's ID.
- `name`: The student's name.
- `marks`: The student's marks.

### StudentManager

Manages the list of students and provides methods to add, edit, delete, sort, search, and rank students.

## Usage

1. Compile the Java files:
   ```sh
   javac Student.java StudentManager.java