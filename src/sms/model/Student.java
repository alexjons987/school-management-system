package sms.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{

    private List<String> attendingCoursesIDs;
    private List<Grade> grades;

    public Student(String firstName, String lastName, int birthYear, String email, String phoneNumber) {
        super(firstName, lastName, birthYear, email, phoneNumber);
        this.attendingCoursesIDs = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public void addCourse(String courseIdentifier) {
        this.attendingCoursesIDs.add(courseIdentifier);
    }

    public List<String> getCourses() {
        return attendingCoursesIDs;
    }

    public void addGrade(Grade grade) {
        this.grades.add(grade);
    }

    public List<Grade> getGrades() {
        return grades;
    }
}