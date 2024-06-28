import java.util.Scanner;
import java.util.Date;
import java.util.UUID;

public class Main {
    private static University university = new University("My University");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nUniversity Management System");
            System.out.println("1. Register Student");
            System.out.println("2. Add Professor");
            System.out.println("3. Add Course");
            System.out.println("4. Enroll Student in Course");
            System.out.println("5. View Students");
            System.out.println("6. View Professors");
            System.out.println("7. View Courses");
            System.out.println("8. View Enrollments");
            System.out.println("9. Save Data");
            System.out.println("10. Load Data");
            System.out.println("11. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (option) {
                case 1:
                    registerStudent(scanner);
                    break;
                case 2:
                    addProfessor(scanner);
                    break;
                case 3:
                    addCourse(scanner);
                    break;
                case 4:
                    enrollStudentInCourse(scanner);
                    break;
                case 5:
                    viewStudents();
                    break;
                case 6:
                    viewProfessors();
                    break;
                case 7:
                    viewCourses();
                    break;
                case 8:
                    viewEnrollments();
                    break;
                case 9:
                    saveData(scanner);
                    break;
                case 10:
                    loadData(scanner);
                    break;
                case 11:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void registerStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student contact: ");
        String contact = scanner.nextLine();

        Student student = new Student(id, name, contact);
        university.addStudent(student);
        System.out.println("Student registered successfully.");
    }

    private static void addProfessor(Scanner scanner) {
        System.out.print("Enter professor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter professor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter professor contact: ");
        String contact = scanner.nextLine();
        System.out.print("Enter professor speciality: ");
        String speciality = scanner.nextLine();

        Professor professor = new Professor(id, name, contact, speciality);
        university.addProfessor(professor);
        System.out.println("Professor added successfully.");
    }

    private static void addCourse(Scanner scanner) {
        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter professor ID for the course: ");
        int professorId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Professor professor = null;
        for (Professor prof : university.getProfessors()) {
            if (prof.getId() == professorId) {
                professor = prof;
                break;
            }
        }

        if (professor == null) {
            System.out.println("Professor not found. Course not added.");
            return;
        }

        Course course = new Course(courseId, courseName, professor);
        university.addCourse(course);
        System.out.println("Course added successfully.");
    }

    private static void enrollStudentInCourse(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();

        Student student = null;
        for (Student stud : university.getStudents()) {
            if (stud.getId() == studentId) {
                student = stud;
                break;
            }
        }

        if (student == null) {
            System.out.println("Student not found. Enrollment failed.");
            return;
        }

        Course course = null;
        for (Course cour : university.getCourses()) {
            if (cour.getc_id().equals(courseId)) {
                course = cour;
                break;
            }
        }

        if (course == null) {
            System.out.println("Course not found. Enrollment failed.");
            return;
        }

        university.enrollStudentInCourse(student, course);
        System.out.println("Student enrolled in course successfully.");
    }

    private static void viewStudents() {
        System.out.println("List of Students:");
        for (Student student : university.getStudents()) {
            System.out.println(student);
        }
    }

    private static void viewProfessors() {
        System.out.println("List of Professors:");
        for (Professor professor : university.getProfessors()) {
            System.out.println(professor);
        }
    }

    private static void viewCourses() {
        System.out.println("List of Courses:");
        for (Course course : university.getCourses()) {
            System.out.println(course);
        }
    }

    private static void viewEnrollments() {
        System.out.println("List of Enrollments:");
        for (Enrollment enrollment : university.getEnrollments()) {
            System.out.println(enrollment);
        }
    }

    private static void saveData(Scanner scanner) {
        System.out.print("Enter file name to save data: ");
        String fileName = scanner.nextLine();
        university.saveData(fileName);
    }

    private static void loadData(Scanner scanner) {
        System.out.print("Enter file name to load data: ");
        String fileName = scanner.nextLine();
        University loadedUniversity = University.loadData(fileName);
        if (loadedUniversity != null) {
            university = loadedUniversity;
        }
    }
}
