package sms.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{

    private List<String> attendingCoursesIDs;
    private List<Grade> grades;

    public Student() {}

    public Student(String firstName, String lastName, int birthYear, String email, String phoneNumber) {
        super(firstName, lastName, birthYear, email, phoneNumber);
        this.attendingCoursesIDs = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public List<String> getAttendingCoursesIDs() {
        return attendingCoursesIDs;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void addCourse(String courseIdentifier) {
        this.attendingCoursesIDs.add(courseIdentifier);
    }

    public void addGrade(Grade grade) {
        this.grades.add(grade);
    }
}