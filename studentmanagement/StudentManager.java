import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void editStudent(int id, String newName, double newMarks) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(newName);
                student.setMarks(newMarks);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public void sortStudentsByMarks() {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        for (int i = 0; i < students.size(); i++) {
            System.out.println("Student " + (i + 1) + ": " + students.get(i));
        }
    }

    public Student searchStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private String rankStudents(double mark) {
        if (mark >= 0 && mark < 5.0) {
            return "Fail";
        } else if (mark >= 5.0 && mark < 6.5) {
            return "Medium";
        } else if (mark >= 6.5 && mark < 7.5) {
            return "Good";
        } else if (mark >= 7.5 && mark < 9.0) {
            return "Very Good";
        } else if (mark >= 9.0 && mark <= 10.0) {
            return "Excellent";
        }
        return null;
    }

    public void rankStudents( ) {
        for (Student student : students) {
            String rank = rankStudents(student.getMarks());
            System.out.println(student + ", Rank='" + rank + "'");
        }
    }

    public void displayStudents() {
        for (Student student : students) {
            String rank = rankStudents(student.getMarks());
            System.out.println(student + ", Rank='" + rank + "'");
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Sort Students by Marks");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Rank Students");
            System.out.println("7. Display All Students");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Insert ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Insert Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Insert Marks: ");
                    double marks = scanner.nextDouble();
                    manager.addStudent(new Student(id, name, marks));
                    break;
                case 2:
                    System.out.print("Enter ID of student to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Insert New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Insert New Marks: ");
                    double newMarks = scanner.nextDouble();
                    manager.editStudent(editId, newName, newMarks);
                    break;
                case 3:
                    System.out.print("Enter ID of student to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteStudent(deleteId);
                    break;
                case 4:
                    manager.sortStudentsByMarks();
                    System.out.println("Students sorted by marks.");
                    break;
                case 5:
                    System.out.print("Enter ID of student to search: ");
                    int searchId = scanner.nextInt();
                    Student student = manager.searchStudentById(searchId);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 6:
                    manager.rankStudents();
                    break;
                case 7:
                    manager.displayStudents();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
