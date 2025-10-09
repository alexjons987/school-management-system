package sms.model;

public class Course {
    private String courseIdentifier;
    private String courseName;
    private String subject;
    private Teacher courseManager;

    public Course() {}

    public Course(String courseIdentifier, String name, String subject, Teacher courseManager) {
        this.courseIdentifier = courseIdentifier;
        this.courseName = name;
        this.subject = subject;
        this.courseManager = courseManager;
    }

    public String getCourseIdentifier() { return courseIdentifier; }

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

    public boolean addStudentToCourse(Student student) {
        if (student.getAttendingCoursesIDs().contains(courseIdentifier)) {
           return false;
        }
        student.addCourse(courseIdentifier);
        return true;
    }

    public boolean removeStudentFromCourse(Student student) {
        if(!student.getAttendingCoursesIDs().contains(courseIdentifier)) {
            return false;
        }
        // student.removeCourse(courseIdentifier); // TODO: Implement removeCourse
        return true;
    }
}
