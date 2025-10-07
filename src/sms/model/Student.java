package sms.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person{

    private List<Grade> grades;

    public Student(String firstName, String lastName, int birthYear, String email, String phoneNumber) {
        super(firstName, lastName, birthYear, email, phoneNumber);
        grades = new ArrayList<>();
    }
}