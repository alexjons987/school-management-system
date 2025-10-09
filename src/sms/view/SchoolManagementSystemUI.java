package sms.view;

import sms.model.Course;
import sms.model.Grade;
import sms.model.Student;
import sms.model.Teacher;

import java.util.ArrayList;
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
                //gradeStudent(scanner, students); // TODO: Refactor gradeStudent method (courseIdentifier is added, courses list is removed )
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
//        System.out.println("- Grade student -");
//
//        // Select student
//        for (int i = 0; i < students.size(); i++) {
//            System.out.printf("%d. %s %s%n", i + 1, students.get(i).getFirstName(), students.get(i).getLastName());
//        }
//        System.out.println("Select student to grade (0 = cancel)");
//        int studentChoice = readIntMenuChoice(scanner, 0, students.size());
//
//        if (studentChoice == 0) {
//            System.out.println("Grading cancelled..");
//            return;
//        }
//
//        Student selectedStudent = students.get(studentChoice - 1);
//
//        // Select course
//        List<Course> selectedStudentCourses = selectedStudent.getCourses();
//        for (int i = 0; i < selectedStudentCourses.size(); i++) {
//            System.out.printf(
//                    "%d. %s %s (CM: %s)%n",
//                    i + 1,
//                    selectedStudentCourses.get(i).getCourseName(),
//                    selectedStudentCourses.get(i).getSubject(),
//                    selectedStudentCourses.get(i).getCourseManager().getFirstName()
//            );
//        }
//        System.out.println("Select course to grade (0 = cancel)");
//        int courseChoice = readIntMenuChoice(scanner, 0, selectedStudentCourses.size());
//
//        if (courseChoice == 0) {
//            System.out.println("Grading cancelled..");
//            return;
//        }
//
//        Course selectedCourse = selectedStudentCourses.get(courseChoice - 1);
//        Teacher selectedCourseCM = selectedCourse.getCourseManager();
//
//        // Set grade for chosen course
//        System.out.println("- Set grade -");
//        System.out.printf("* Student: %s %s%n", selectedStudent.getFirstName(), selectedStudent.getLastName());
//        System.out.printf("* Course: %s %s%n", selectedCourse.getCourseName(), selectedCourse.getSubject());
//        System.out.printf("* Course Manager: %s %s%n", selectedCourseCM.getFirstName(), selectedCourseCM.getLastName());
//        System.out.print("Set grade (0-100)");
//        int courseGrade = readIntMenuChoice(scanner, 0, 100);
//
//        // Add optional teacher comment
//        System.out.print("(OPTIONAL) Teacher comment: ");
//        String teacherComment = scanner.nextLine();
//
//        // Add grade to student
//        Grade grade = new Grade(selectedStudent, selectedCourse, courseGrade, teacherComment);
//        selectedStudent.addGrade(grade);
//
//        System.out.println("\n\n");
//        for (Grade g : selectedStudent.getGrades()) { // TODO: Remove this test printout
//            System.out.println(g.toString());
//        }
    }

    public static void manageTeachersMenu(Scanner scanner) { // TODO: Implement, add relevant params
        /**
         *     1. Add Teacher
         *     2. Remove Teacher
         *     3. List Teachers
         *     4. List courses of teacher -> select teacher
         */
    }

    public static void manageCoursesMenu(Scanner scanner, List<Student> students, List<Teacher> teachers, List <Course> courses) {
        /**
         *     1. Create course
         *     2. Remove course
         *     3. Add student to course
         *     4. Remove student from course
         *     5. List all courses and their course manager
         *     6. Set course manager for course
         *     7. See course details -> select course -> list course name, subject, course manager, students
         */
        System.out.println("1. Add course");
        System.out.println("2. Remove course");
        System.out.println("3. Add student to course");
        System.out.println("4. Remove student from course");
        System.out.println("5. List all courses and their course manager");
        System.out.println("6. Set course manager for course");
        System.out.println("7. See course details");
        System.out.println("0. Go back");

        int userChoice = readIntMenuChoice(new Scanner(System.in), 0, 7);

        switch (userChoice) {
            case 0:
                return;
            case 1:
                // TODO: Implement Add course
                break;
            case 2:
                // TODO: Implement Remove course
                break;
            case 3:
                addStudentToCourse(scanner, students, courses);
                break;
            case 4:
                removeStudentFromCourse(scanner, students, courses);
                break;
            case 5:
                // TODO: Implement List all courses and their course manager
                break;
            case 6:
                setCourseManager(scanner, teachers, courses);
                break;
            case 7:
                // TODO: See course details
                break;
        }
    }

    private static void addStudentToCourse(Scanner scanner, List<Student> students, List<Course> courses)
    {
        System.out.println("- Add student to course -");

        // Select student
        for (int i = 0; i < students.size(); i++)
        {
            System.out.printf("%d. %s %s%n", i + 1, students.get(i).getFirstName(), students.get(i).getLastName());
        }
        System.out.println("Select student (0 = cancel)");
        int studentChoice = readIntMenuChoice(scanner, 0, students.size());

        if (studentChoice == 0)
        {
            System.out.println("Add student to course cancelled..");
            return;
        }

        Student selectedStudent = students.get(studentChoice - 1);

        // Select course
        for (int i = 0; i < courses.size(); i++)
        {
            System.out.printf(
                    "%d. %s %s (CM: %s)%n",
                    i + 1,
                    courses.get(i).getCourseName(),
                    courses.get(i).getSubject(),
                    courses.get(i).getCourseManager().getFirstName()
            );
        }
        System.out.println("Select course (0 = cancel)");
        int courseChoice = readIntMenuChoice(scanner, 0, courses.size());

        if (courseChoice == 0)
        {
            System.out.println("Add student to course cancelled..");
            return;
        }

        Course selectedCourse = courses.get(courseChoice - 1);
        boolean addedStudentToCourse = selectedCourse.addStudentToCourse(selectedStudent);

        if (addedStudentToCourse) {
            System.out.printf("%s %s has been added to the %s course.%n",
                    selectedStudent.getFirstName(),
                    selectedStudent.getLastName(),
                    selectedCourse.getCourseName());
        }
        else {
            System.out.printf("%s %s is already added to the %s course.%n",
                    selectedStudent.getFirstName(),
                    selectedStudent.getLastName(),
                    selectedCourse.getCourseName());
        }
    }

    private static void removeStudentFromCourse(Scanner scanner, List<Student> students, List<Course> courses) {
        System.out.println("- Remove student from course -");

        // Select student
        for (int i = 0; i < students.size(); i++)
        {
            System.out.printf("%d. %s %s%n", i + 1, students.get(i).getFirstName(), students.get(i).getLastName());
        }
        System.out.println("Select student (0 = cancel)");
        int studentChoice = readIntMenuChoice(scanner, 0, students.size());

        if (studentChoice == 0)
        {
            System.out.println("Remove student from course cancelled..");
            return;
        }

        Student selectedStudent = students.get(studentChoice - 1);
        ArrayList<Course> studentCourses = new ArrayList<>();

        for (String courseID : selectedStudent.getCourses()) {
            courses.stream()
                    .filter(c -> c.getCourseIdentifier().equals(courseID))
                    .findFirst().ifPresent(studentCourses::add);
        }

        if (studentCourses.isEmpty())
        {
            System.out.println("The student does not attend any courses..");
            return;
        }

        // Select course
        for (int i = 0; i < studentCourses.size(); i++)
        {
            System.out.printf(
                    "%d. %s %s (CM: %s)%n",
                    i + 1,
                    studentCourses.get(i).getCourseName(),
                    studentCourses.get(i).getSubject(),
                    studentCourses.get(i).getCourseManager().getFirstName()
            );
        }
        System.out.println("Select course (0 = cancel)");
        int courseChoice = readIntMenuChoice(scanner, 0, studentCourses.size());

        if (courseChoice == 0)
        {
            System.out.println("Remove student from course cancelled..");
            return;
        }

        Course selectedCourse = studentCourses.get(courseChoice - 1);
        boolean removedFromCourse = selectedCourse.removeStudentFromCourse(selectedStudent);

        if (removedFromCourse) {
            System.out.printf("%s %s has been removed from the %s course.%n",
                    selectedStudent.getFirstName(),
                    selectedStudent.getLastName(),
                    selectedCourse.getCourseName());
        }
        else {
            System.out.printf("%s %s does not attend the %s course.%n",
                    selectedStudent.getFirstName(),
                    selectedStudent.getLastName(),
                    selectedCourse.getCourseName());
        }
    }

    public static void setCourseManager(Scanner scanner, List<Teacher> teachers, List<Course> courses) {
        System.out.println("- Set course manager for course -");

        // Select course
        for (int i = 0; i < courses.size(); i++)
        {
            System.out.printf(
                    "%d. %s %s (CM: %s)%n",
                    i + 1,
                    courses.get(i).getCourseName(),
                    courses.get(i).getSubject(),
                    courses.get(i).getCourseManager().getFirstName()
            );
        }
        System.out.println("Select course (0 = cancel)");
        int courseChoice = readIntMenuChoice(scanner, 0, courses.size());

        if (courseChoice == 0)
        {
            System.out.println("Set course manager cancelled..");
            return;
        }

        Course selectedCourse = courses.get(courseChoice - 1);

        // Select teacher
        for (int i = 0; i < teachers.size(); i++)
        {
            System.out.printf("%d. %s %s%n", i + 1, teachers.get(i).getFirstName(), teachers.get(i).getLastName());
        }
        System.out.println("Select teacher to be course manager (0 = cancel)");
        int teacherChoice = readIntMenuChoice(scanner, 0, teachers.size());

        if (teacherChoice == 0)
        {
            System.out.println("Set course manager cancelled..");
            return;
        }

        Teacher selectedTeacher = teachers.get(teacherChoice - 1);
        selectedCourse.setCourseManager(selectedTeacher);
        System.out.printf("%s %s is the new course manager of %s.%n",
                selectedTeacher.getFirstName(),
                selectedTeacher.getLastName(),
                selectedCourse.getCourseName());
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
