package sms.model;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private List<Course> courses;

    public Teacher(String firstName, String lastName, int birthYear, String email, String phoneNumber) {
        super(firstName, lastName, birthYear, email, phoneNumber);
        courses = new ArrayList<>();
    }
}