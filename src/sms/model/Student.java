package sms.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{

    private List<Course> courses;
    private List<Grade> grades;

    public Student(String firstName, String lastName, int birthYear, String email, String phoneNumber) {
        super(firstName, lastName, birthYear, email, phoneNumber);
        this.courses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addGrade(Grade grade) {
        this.grades.add(grade);
    }

    public List<Grade> getGrades() {
        return grades;
    }
}