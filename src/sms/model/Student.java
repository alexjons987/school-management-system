package sms.model;

import java.util.HashMap;
import java.util.Map;

public class Student extends Person{

    private Map<Course, Grade> courseGrades;

    public Student(String firstName, String lastName, int birthYear, String email, String phoneNumber) {
        super(firstName, lastName, birthYear, email, phoneNumber);
        courseGrades = new HashMap<>();
    }
}