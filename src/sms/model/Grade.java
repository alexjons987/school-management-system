package sms.model;

public class Grade
{
    private Student student;
    private Course course;
    private int value;
    private String comments;

    public Grade(Student student, Course course, int value, String comments) {
        this.student = student;
        this.course = course;
        this.value = value;
        this.comments = comments;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public int getValue() {
        return value;
    }

    public String getComments() {
        return comments;
    }

    public String toString() {
        return String.format(
                "%s %s - %s: %d | %s",
                this.student.getFirstName(),
                this.student.getLastName(),
                this.course.getCourseName(),
                this.value,
                this.comments
        );
    }
}
