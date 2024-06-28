import java.io.Serializable;
import java.util.Date;

public class Enrollment implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Student student;
    private Course course;
    private Date date;
    private String enrollmentId;

    public Enrollment(int id, Student student, Course course, Date date, String enrollmentId) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.date = date;
        this.enrollmentId = enrollmentId;
    }

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public Date getDate() {
        return date;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", date=" + date +
                ", enrollmentId='" + enrollmentId + '\'' +
                '}';
    }
}
