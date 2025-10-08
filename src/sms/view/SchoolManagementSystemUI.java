package sms.view;

import sms.model.Course;
import sms.model.Grade;
import sms.model.Student;
import sms.model.Teacher;

import java.util.List;
import java.util.Scanner;

public class SchoolManagementSystemUI {

    public static void printTitle() {
        System.out.println("- School Management System -");
    }

    public static int startMenu(Scanner scanner) {
        System.out.println("1. Manage students");
        System.out.println("2. Manage teachers");
        System.out.println("3. Manage courses");
        System.out.println("0. Save and exit");

        return readIntMenuChoice(scanner, 0, 3);
    }

    public static void manageStudentsMenu(Scanner scanner, List<Student> students) { // TODO: Implement
        /**
         *     1. Add student
         *     2. Remove student
         *     3. Grade student
         *     4. List students
         *     5. List grades of student -> select student
         *     0. Go back
         */
        System.out.println("- Manage students -");
        System.out.println("1. Add student");
        System.out.println("2. Remove student");
        System.out.println("3. Grade student");
        System.out.println("4. List students");
        System.out.println("5. List grades of student");
        System.out.println("0. Go back");

        int menuChoice = readIntMenuChoice(scanner, 0, 5);

        switch (menuChoice) {
            case 0:
                return;
            case 1:
                // TODO: Implement Add student
                break;
            case 2:
                // TODO: Implement Remove student
                break;
            case 3:
                gradeStudent(scanner, students);
                break;
            case 4:
                // TODO: Implement List students
                break;
            case 5:
                // TODO: Implement List grades of student
                break;
        }
    }

    private static void gradeStudent(Scanner scanner, List<Student> students) {
        System.out.println("- Grade student -");

        // Select student
        for (int i = 0; i < students.size(); i++) {
            System.out.printf("%d. %s %s %n", i + 1, students.get(i).getFirstName(), students.get(i).getLastName());
        }
        System.out.println("Select student to grade (0 = cancel)");
        int studentChoice = readIntMenuChoice(scanner, 0, students.size());

        if (studentChoice == 0) {
            System.out.println("Grading cancelled..");
            return;
        }

        Student selectedStudent = students.get(studentChoice - 1);

        // Select course
        List<Course> selectedStudentCourses = selectedStudent.getCourses();
        for (int i = 0; i < selectedStudentCourses.size(); i++) {
            System.out.printf(
                    "%d. %s %s (CM: %s)%n",
                    i + 1,
                    selectedStudentCourses.get(i).getCourseName(),
                    selectedStudentCourses.get(i).getSubject(),
                    selectedStudentCourses.get(i).getCourseManager().getFirstName()
            );
        }
        System.out.println("Select course to grade (0 = cancel)");
        int courseChoice = readIntMenuChoice(scanner, 0, selectedStudentCourses.size());

        if (courseChoice == 0) {
            System.out.println("Grading cancelled..");
            return;
        }

        Course selectedCourse = selectedStudentCourses.get(courseChoice - 1);
        Teacher selectedCourseCM = selectedCourse.getCourseManager();

        // Set grade for chosen course
        System.out.println("- Set grade -");
        System.out.printf("* Student: %s %s%n", selectedStudent.getFirstName(), selectedStudent.getLastName());
        System.out.printf("* Course: %s %s%n", selectedCourse.getCourseName(), selectedCourse.getSubject());
        System.out.printf("* Course Manager: %s %s%n", selectedCourseCM.getFirstName(), selectedCourseCM.getLastName());
        System.out.print("Set grade (0-100)");
        int courseGrade = readIntMenuChoice(scanner, 0, 100);

        // Add optional teacher comment
        System.out.print("(OPTIONAL) Teacher comment: ");
        String teacherComment = scanner.nextLine();

        // Add grade to student
        Grade grade = new Grade(selectedStudent, selectedCourse, courseGrade, teacherComment);
        selectedStudent.addGrade(grade);

        System.out.println("\n\n");
        for (Grade g : selectedStudent.getGrades()) { // TODO: Remove this test printout
            System.out.println(g.toString());
        }
    }

    public static void manageTeachersMenu(Scanner scanner) { // TODO: Implement, add relevant params
        /**
         *     1. Add Teacher
         *     2. Remove Teacher
         *     3. List Teachers
         *     4. List courses of teacher -> select teacher
         */
    }

    public static void manageCoursesMenu(Scanner scanner, List<Course> courses, List<Teacher> teachers) { // TODO: Implement, add relevant params
        /**
         *     1. Add course
         *     2. Remove course
         *     3. Add student to course
         *     4. List all courses and their course manager
         *     5. Assign course to teacher -> warn if you are replacing current teacher
         *     6. See course details -> select course -> list course name, subject, course manager, students
         */

        System.out.println("- Manage courses -");
        System.out.println("1. Add course");
        System.out.println("2. Remove course");
        System.out.println("3. Add student to course");
        System.out.println("4. List courses");
        System.out.println("5. Assign course to teacher");
        System.out.println("6. Course details");
        System.out.println("0. Go back");

        int menuChoice = readIntMenuChoice(scanner, 0, 6);

        switch (menuChoice) {
            case 0:
                return;
            case 1:
                addCourse(scanner, courses, teachers);
                break;
            case 2:
                removeCourse(scanner, courses);
                break;
            case 3:
                // ToDo: Implement Add student to course
                break;
            case 4:
                // TODO: Implement List courses
                break;
            case 5:
                // TODO: Implement Assign teacher to course
                break;
            case 6:
                // ToDo: Implement course details
                break;
        }
    }

    public static void addCourse(Scanner sc, List<Course> courses, List<Teacher> teachers) {
        System.out.println("- Add course -");
        System.out.println("Add name of the course ");
        System.out.print("> ");
        String name = sc.nextLine().trim();
        System.out.println("Add subject");
        System.out.print("> ");
        String subject = sc.nextLine().trim();

        // List available teachers to select
        System.out.printf("Select teacher (1 - %d)%n", teachers.size());
        for(int i = 0; i < teachers.size(); i++) {
            System.out.printf("%d. %s %s%n", i + 1, teachers.get(i).getFirstName(), teachers.get(i).getLastName());
        }
        int selected = readIntMenuChoice(sc, 1, teachers.size());
        Teacher teacher = teachers.get(selected - 1);

        // Create new course and add it to courses list
        Course courseToAdd = new Course(name, subject, teacher);
        courses.add(courseToAdd);

        System.out.println("A new course has been added:");
        System.out.printf("Name: %s%n", name);
        System.out.printf("Subject: %s%n", subject);
        System.out.printf("Course Manager: %s %s%n", teacher.getFirstName(), teacher.getLastName());
        System.out.println(" ");
    }

    public static void removeCourse(Scanner sc, List<Course> courses) {
        // List of courses
        // Select course to remove from courses
        // Add a isRemoved field to course? Remove course from attending students?
        System.out.println("- Remove course -");

        // List available courses to select
        System.out.printf("Select course (1 - %d)%n", courses.size());
        for(int i = 0; i < courses.size(); i++) {
            Course current = courses.get(i);
            System.out.printf("%d. %s | %s | %s %s%n", i + 1, current.getCourseName(), current.getSubject(), current.getCourseManager().getFirstName(), current.getCourseManager().getLastName());
        }


    }

    /**
     * Read and clean user input to prevent trailing newlines. Allows only inputs between {@code min} and {@code max} (inclusive)
     * @param sc Scanner
     * @param min Lowest allowed integer input
     * @param max Highest allowed integer input
     * @return Integer from user input
     */
    private static int readIntMenuChoice(Scanner sc, int min, int max) {
        while (true) {
            System.out.print("> ");
            String userInput = sc.nextLine().trim();
            try {
                int choice = Integer.parseInt(userInput);
                if (choice >= min && choice <= max)
                    return choice;
            } catch (NumberFormatException ignored) {}
            System.out.printf("Please enter a number %d - %d.%n", min, max);
        }
    }
}
