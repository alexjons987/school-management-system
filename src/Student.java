import java.util.ArrayList;
import java.util.List;

public class Student extends Person{

    // private List<Course> courses = new ArrayList<>();

    public Student(String firstName, String lastName, int birthYear, String email, String phoneNumber) {
        super(firstName, lastName, birthYear, email, phoneNumber);
    }
}