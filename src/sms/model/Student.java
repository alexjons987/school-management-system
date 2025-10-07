package sms.model;

public class Student extends Person{

    // private List<sms.model.Course> courses = new ArrayList<>();

    public Student(String firstName, String lastName, int birthYear, String email, String phoneNumber) {
        super(firstName, lastName, birthYear, email, phoneNumber);
    }
}