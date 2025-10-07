import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private String subject;
    private Teacher courseManager;
    private List<Student> students;

    public Course(String name, String subject, Teacher courseManager) {
        this.courseName = name;
        this.subject = subject;
        this.courseManager = courseManager;
        this.students = new ArrayList<Student>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Teacher getCourseManager() {
        return courseManager;
    }

    public void setCourseManager(Teacher courseManager) {
        this.courseManager = courseManager;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean addStudentToCourse(Student student) {
        if(!students.contains(student)) {
            students.add(student);
            student.addCourse(this);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeStudentFromCourse(Student student) {
        if(students.contains(student)) {
            students.remove(student);
            student.removeCourse(this);
            return true;
        } else {
            return false;
        }
    }
}
