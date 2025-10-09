package sms.model;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private List<String> managedCoursesIDs;

    public Teacher() {}

    public Teacher(String firstName, String lastName, int birthYear, String email, String phoneNumber) {
        super(firstName, lastName, birthYear, email, phoneNumber);
        this.managedCoursesIDs = new ArrayList<>();
    }

    public void addCourse(String courseIdentifier) {
        if (!this.managedCoursesIDs.contains(courseIdentifier)) {
            this.managedCoursesIDs.add(courseIdentifier);
        }
    }

    public void removeCourse(String courseIdentifier) {
        this.managedCoursesIDs.remove(courseIdentifier);
    }

    public List<String> getManagedCoursesIDs() {
        return managedCoursesIDs;
    }
}