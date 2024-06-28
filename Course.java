import java.util.ArrayList;
import java.util.List;

public class Course {
    private String c_id;
    private String c_name;
    private Professor professor;
    private List<Student> students;

    public Course(String c_id, String c_name, Professor professor) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.professor = professor;
        this.students = new ArrayList<>();
    }

    public String getc_id() {
        return c_id;
    }

    public String getc_name() {
        return c_name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "Id=" + c_id +
                ", Course Name=" + c_name +
                ", Professor=" + professor +
                ", Students='" + students + '\'' +
                '}';
    }
}


/*When to Use Setters
Setters are useful when:

The properties of an object need to be modified after the object is created.
You want to provide controlled access to certain attributes.
You need to validate or process data before updating a property. */