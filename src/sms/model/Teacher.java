package sms.model;

public class Teacher extends Person {
    // private List<sms.model.Course> courses = new ArrayList<>();

    public Teacher(String firstName, String lastName, int birthYear, String email, String phoneNumber) {
        super(firstName, lastName, birthYear, email, phoneNumber);
    }
}