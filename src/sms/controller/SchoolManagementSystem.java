package sms.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import sms.model.Course;
import sms.model.Student;
import sms.model.Teacher;
import sms.service.SchoolDataSnapshot;
import sms.view.SchoolManagementSystemUI;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SchoolManagementSystem {

    List<Student> students;
    List<Teacher> teachers;
    List<Course> courses;
    private final File file = new File("schoolDB.json");

    public SchoolManagementSystem() {}

    public void start() {
        try {
            initializeSMS();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        mainSMS();
    }

    private void initializeSMS() {
        try {
            readFromDatabase();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
                    SchoolManagementSystemUI.manageStudentsMenu(scanner, students, courses);
                    break;
                case 2:
                    SchoolManagementSystemUI.manageTeachersMenu(scanner, teachers);
                    break;
                case 3:
                    SchoolManagementSystemUI.manageCoursesMenu(scanner, students, teachers, courses);
                    break;
            }
        } while (menuChoice != 0);

        saveToDatabase();
        System.out.println("Goodbye!");
    }

    private void readFromDatabase() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper()
                //.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE)
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        if (!file.exists()) {
            System.out.printf("WARNING! %s was not found. Adding test data...%n", file.getName());
            addTestData();
        } else {
            try {
                SchoolDataSnapshot dataSnapshot = objectMapper.readValue(this.file, SchoolDataSnapshot.class);
                this.students = dataSnapshot.getStudents();
                this.teachers = dataSnapshot.getTeachers();
                this.courses = dataSnapshot.getCourses();
            } catch (IOException e) {
                System.out.println("Unable to load data from snapshot (ADDING TEST DATA): " + e);
                addTestData();
            }
        }
    }

    private void saveToDatabase() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> smsData = Map.of(
                    "students", this.students,
                    "teachers", this.teachers,
                    "courses", this.courses
            );
            System.out.printf("Saving to %s... ", this.file.getName());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(this.file, smsData);
            System.out.print("Done!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addTestData() {
        // Create some students
        students.add(new Student("Alexander", "A", 1234, "alex@email.com", "0721234567"));
        students.add(new Student("Hans-Erik", "HE", 2345, "hanserik@email.com", "0722345678"));
        students.add(new Student("Lena", "L", 3456, "lena@email.com", "0723456789"));
        students.add(new Student("Ioana", "I", 4567, "ioana@email.com", "0724567890"));

        // Create some teachers
        teachers.add(new Teacher("Alice", "A.", 1234, "alicea@school.com", "0721234567"));
        teachers.add(new Teacher("Bob", "B.", 2345, "bobb@school.com", "0722345678"));
        teachers.add(new Teacher("Charlie", "C.", 3456, "charliec@school.com", "0723456789"));

        // Create some courses
        courses.add(new Course("IX1303", "Algebra and Geometry", "Math", teachers.get(0)));
        courses.add(new Course("IS1200", "Computer Hardware Engineering", "Engineering", teachers.get(1)));
        courses.add(new Course("IV1351", "Data Storage Paradigms", "Engineering", teachers.get(2)));

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
    }
}
