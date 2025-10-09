package sms.model;

public class Grade
{
    private Student student;
    private String courseIdentifier;
    private int value;
    private String comments;

    public Grade(Student student, String courseIdentifier, int value, String comments) {
        this.student = student;
        this.courseIdentifier = courseIdentifier;
        this.value = value;
        this.comments = comments;
    }

    public Student getStudent() {
        return student;
    }

    public String getCourseIdentifier() {
        return courseIdentifier;
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
                this.courseIdentifier,
                this.value,
                this.comments
        );
    }
}
