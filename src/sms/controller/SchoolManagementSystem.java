package sms.controller;

import sms.model.Course;
import sms.model.Person;
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
            students.add(new Student("Alexander", "A", 1234, "alex@email.com", "0721234567"));
            students.add(new Student("Hans-Erik", "HE", 2345, "hanserik@email.com", "0722345678"));
            students.add(new Student("Lena", "L", 3456, "lena@email.com", "0723456789"));
            students.add(new Student("Ioana", "I", 2000, "ioana@email.com", "0724567890"));

            // Create some teachers
            teachers.add(new Teacher("Alice", "A.", 1234, "alex@email.com", "0721234567"));
            teachers.add(new Teacher("Bob", "B.", 2345, "hanserik@email.com", "0722345678"));
            teachers.add(new Teacher("Charlie", "C.", 3456, "lena@email.com", "0723456789"));

            // Create some courses
            courses = List.of(
                    new Course("IX1303","Algebra and Geometry", "Math", teachers.get(0)),
                    new Course("IS1200","Computer Hardware Engineering", "Engineering", teachers.get(1)),
                    new Course("IV1351","Data Storage Paradigms", "Engineering", teachers.get(2))
            );

            // Add a course manager to each course
            teachers.get(0).addCourse(courses.get(0).getCourseIdentifier());
            teachers.get(1).addCourse(courses.get(1).getCourseIdentifier());
            teachers.get(2).addCourse(courses.get(2).getCourseIdentifier());

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
                    SchoolManagementSystemUI.manageTeachersMenu(scanner, teachers);
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
