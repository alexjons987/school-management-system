package sms.model;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private List<Course> courses;

    public Teacher(String firstName, String lastName, int birthYear, String email, String phoneNumber) {
        super(firstName, lastName, birthYear, email, phoneNumber);
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }
}