package sms.controller;

import sms.model.Course;
import sms.model.Student;
import sms.model.Teacher;
import sms.view.SchoolManagementSystemUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolManagementSystem {

    List<Student> students = new ArrayList<>();
    List<Teacher> teachers = new ArrayList<>();
    List<Course> courses = new ArrayList<>();

    public SchoolManagementSystem() {}

    public void start() {
        try {
            initializeSMS();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mainSMS();
    }

    private void initializeSMS() throws IOException {
        try {
            // TODO: Read previously saved data from JSON database

            // TODO: Remove test data (ONLY USED FOR TESTING PRE-DATABASE)
            // Create some students
            students = List.of(
                    new Student("Alexander", "A", 1234, "alex@email.com", "0721234567"),
                    new Student("Hans-Erik", "HE", 2345, "hanserik@email.com", "0722345678"),
                    new Student("Lena", "L", 3456, "lena@email.com", "0723456789"),
                    new Student("Ioana", "I", 4567, "ioana@email.com", "0724567890")
            );

            // Create some teachers
            teachers = List.of(
                    new Teacher("Alice", "A.", 1234, "alex@email.com", "0721234567"),
                    new Teacher("Bob", "B.", 2345, "hanserik@email.com", "0722345678"),
                    new Teacher("Charlie", "C.", 3456, "lena@email.com", "0723456789")
            );

            // Create some courses
            courses = List.of(
                    new Course("Algebra and Geometry (IX1303)", "Math", teachers.get(0)),
                    new Course("Computer Hardware Engineering (IS1200)", "Engineering", teachers.get(1)),
                    new Course("Data Storage Paradigms (IV1351)", "Engineering", teachers.get(2))
            );

            // Add a course manager to each course
            teachers.get(0).addCourse(courses.get(0));
            teachers.get(1).addCourse(courses.get(1));
            teachers.get(2).addCourse(courses.get(2));

            // Add students to courses
            for (Course course : courses) {
                for (Student student : students) {
                    course.addStudentToCourse(student);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException();
        }
    }

    private void mainSMS() {
        Scanner scanner = new Scanner(System.in);
        int menuChoice;

        do {
            SchoolManagementSystemUI.printTitle();
            menuChoice = SchoolManagementSystemUI.startMenu(scanner);

            switch (menuChoice) {
                case 1:
                    SchoolManagementSystemUI.manageStudentsMenu(scanner, students);
                    break;
                case 2:
                    SchoolManagementSystemUI.manageTeachersMenu(scanner);
                    break;
                case 3:
                    SchoolManagementSystemUI.manageCoursesMenu(scanner, students, teachers, courses);
                    break;
            }
        } while (menuChoice != 0);
        System.out.println("Goodbye!");
        // TODO: Save data to JSON database
    }
}
