import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class University implements Serializable {
    private static final long serialVersionUID = 1L;

    private String universityName;
    private List<Student> students;
    private List<Professor> professors;
    private List<Course> courses;
    private List<Enrollment> enrollments;
    private int nextEnrollmentId = 1;

    public University(String universityName) {
        this.universityName = universityName;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.enrollments = new ArrayList<>();
    }

    // Method to add a student to the university
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to retrieve all students
    public List<Student> getStudents() {
        return students;
    }

    // Method to add a professor to the university
    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    // Method to retrieve all professors
    public List<Professor> getProfessors() {
        return professors;
    }

    // Method to add a course to the university
    public void addCourse(Course course) {
        courses.add(course);
    }

    // Method to retrieve all courses
    public List<Course> getCourses() {
        return courses;
    }

    // Method to enroll a student in a course
    public void enrollStudentInCourse(Student student, Course course) {
        Enrollment enrollment = new Enrollment(nextEnrollmentId++, student, course, new Date(), UUID.randomUUID().toString());
        enrollments.add(enrollment);
        course.addStudent(student);
    }

    // Method to retrieve all enrollments
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    // Method to save university data to a file
    public void saveData(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("University data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load university data from a file
    public static University loadData(String fileName) {
        University university = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            university = (University) ois.readObject();
            System.out.println("University data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return university;
    }

    @Override
    public String toString() {
        return "University{" +
                "universityName='" + universityName + '\'' +
                ", students=" + students +
                ", professors=" + professors +
                ", courses=" + courses +
                ", enrollments=" + enrollments +
                '}';
    }
}
