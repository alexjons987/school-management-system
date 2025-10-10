package sms.model;

public class Grade {
    private String courseIdentifier;
    private int value;
    private String comments;

    public Grade() {}

    public Grade(String courseIdentifier, int value, String comments) {
        this.courseIdentifier = courseIdentifier;
        this.value = value;
        this.comments = comments;
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
                "%s: %d | Comment: %s",
                this.courseIdentifier,
                this.value,
                this.comments
        );
    }
}
