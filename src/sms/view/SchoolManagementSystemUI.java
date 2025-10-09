package sms.view;

import sms.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolManagementSystemUI {

    public static void printTitle() {
        System.out.printf("%n- School Management System -%n");
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
                addPerson(scanner, students, "Student");
                break;
            case 2:
                removePerson(scanner, students, "Student");
                break;
            case 3:
                //gradeStudent(scanner, students); // TODO: Refactor gradeStudent method (courseIdentifier is added, courses list is removed )
                break;
            case 4:
                System.out.println("- List students -");
                listPersons(students);
                break;
            case 5:
                // TODO: Implement List grades of student
                break;
        }
    }
    private static <T extends Person> void addPerson(Scanner scanner, List<T> persons, String type) {
   // private static void addPerson(Scanner scanner, List<Person> persons, String type) {
        System.out.printf("- Add %s -%n",type);
        String firstName = askData(scanner, "First name");
        String lastName = askData(scanner, "Last name");
        System.out.println("Birth year: ");
        int birthYear = readIntMenuChoice(scanner,1875,2020);
        String email = askData(scanner, "Email address");
        String phone = askData(scanner, "Phone number");

        boolean alreadyRegistered = persons.stream().anyMatch(person ->
                person.getFirstName().equals(firstName)
                && person.getLastName().equals(lastName)
                && person.getBirthYear() == (birthYear)
                && person.getEmail().equals(email)
                && person.getPhoneNumber().equals(phone));
        if(alreadyRegistered) {
            System.out.printf("%s already registered%n", type);
        } else {
            Person newPerson;
            if (type.equals("Student")) {
                persons.add((T) new Student(firstName, lastName, birthYear, email, phone));
            } else {
                persons.add((T) new Teacher(firstName, lastName, birthYear, email, phone));
            }
            System.out.printf("%s %s %s is added into the school management system!%n", type, firstName, lastName);
        }
    }
    private static <T extends Person> void removePerson(Scanner scanner, List<T> persons, String type) {
   // private static void removePerson(Scanner scanner, List<Person> persons, String type) {
        System.out.printf("- Remove %s -%n", type);

        if (persons.isEmpty()) {
            System.out.println("No persons available to remove");
            return;
        }
        // Select person
        for (int i = 0; i < persons.size(); i++) {
            System.out.printf("%d. %s %s%n", i + 1, persons.get(i).getFirstName(), persons.get(i).getLastName());
        }
        System.out.println("Select person to remove (0 = cancel)");
        int studentChoice = readIntMenuChoice(scanner, 0, persons.size());

        if (studentChoice == 0) {
            System.out.println("Operation cancelled..");
            return;
        }
        Person personRemoved = persons.get(studentChoice -1);
        persons.remove(studentChoice -1);
        System.out.printf("%s %s %s has been removed from the school management system!",type, personRemoved.getFirstName(), personRemoved.getLastName());
    }

    private static <T extends Person> void listPersons(List<T> persons) {
   // private static void listpersons(Scanner scanner, List<Person> persons) {
        // Select student
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i); // get once
            System.out.printf("%d. Name: %s %s birth year: %d email: %s phone: %s %n",
                    i + 1,
                    person.getFirstName(),
                    person.getLastName(),
                    person.getBirthYear(),
                    person.getEmail(),
                    person.getPhoneNumber());
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

    public static void manageTeachersMenu(Scanner scanner, List<Teacher> teachers) { // TODO: Implement, add relevant params
        /**
         *     1. Add Teacher
         *     2. Remove Teacher
         *     3. List Teachers
         *     4. List courses of teacher -> select teacher
         */
        System.out.println("- Manage Teachers -");
        System.out.println("1. Add teacher");
        System.out.println("2. Remove teacher");
        System.out.println("3. List teachers");
        System.out.println("4. List courses of teacher");
        System.out.println("0. Go back");

        int menuChoice = readIntMenuChoice(scanner, 0, 5);

        switch (menuChoice) {
            case 0:
                return;
            case 1:
                addPerson(scanner, teachers, "Teacher");
                break;
            case 2:
                removePerson(scanner, teachers, "Teacher");
                break;
            case 3:
                System.out.println("- List teachers -");
                listPersons(teachers);
                break;
            case 4:
                // TODO: Implement List of courses for teacher
                break;
        }
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
        System.out.println("1. Create course");
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
                createCourse(scanner, courses, teachers);
                break;
            case 2:
                removeCourse(scanner, courses);
                break;
            case 3:
                addStudentToCourse(scanner, students, courses);
                break;
            case 4:
                removeStudentFromCourse(scanner, students, courses);
                break;
            case 5:
                listCourses(courses);
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

    public static void createCourse(Scanner sc, List<Course> courses, List<Teacher> teachers) {
        System.out.println("- Add course -");
        System.out.println("Add name of the course ");
        System.out.print("> ");
        String name = sc.nextLine().trim();
        System.out.println("Add subject");
        System.out.print("> ");
        String subject = sc.nextLine().trim();
        System.out.println("Add course ID");
        System.out.print("> ");
        String courseID = sc.nextLine().trim();

        // List available teachers to select
        System.out.printf("Select teacher (1 - %d)%n", teachers.size());
        for(int i = 0; i < teachers.size(); i++) {
            System.out.printf("%d. %s %s%n", i + 1, teachers.get(i).getFirstName(), teachers.get(i).getLastName());
        }
        int selected = readIntMenuChoice(sc, 1, teachers.size());
        Teacher teacher = teachers.get(selected - 1);

        // Create new course and add it to courses list
        Course courseToAdd = new Course(courseID, name, subject, teacher);
        courses.add(courseToAdd);
        System.out.println(courses.size());

        System.out.println("A new course has been added:");
        System.out.printf("Name: %s%n", name);
        System.out.printf("Subject: %s%n", subject);
        System.out.printf("ID: %s%n", courseID);
        System.out.printf("Course Manager: %s %s%n", teacher.getFirstName(), teacher.getLastName());
        System.out.println();
    }

    public static void removeCourse(Scanner sc, List<Course> courses) {
        if(courses.isEmpty()) {
            System.out.println("The courses catalog is empty");
            System.out.println();
            return;
        }

        System.out.println("- Remove course -");

        // List available courses to select
        System.out.printf("Select course to remove (1 - %d)%n", courses.size());
        for(int i = 0; i < courses.size(); i++) {
            Course current = courses.get(i);
            System.out.printf(
                    "%d. %s | %s | %s | %s %s%n",
                    i + 1,
                    current.getCourseIdentifier(),
                    current.getCourseName(),
                    current.getSubject(),
                    current.getCourseManager().getFirstName(),
                    current.getCourseManager().getLastName());
        }

        int selectedInput = readIntMenuChoice(sc, 1, courses.size());
        int indexToRemove = selectedInput - 1;

        Course course = courses.get(indexToRemove);
        String message = String.format(
                "This course has been removed:%n" +
                        "Name: %s%n" +
                        "Subject: %s%n" +
                        "ID: %s%n" +
                        "Course Manager: %s %s%n",
                course.getCourseName(),
                course.getSubject(),
                course.getCourseIdentifier(),
                course.getCourseManager().getFirstName(),
                course.getCourseManager().getLastName()
        );

        courses.remove(indexToRemove);
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void listCourses(List<Course> courses) {
        courses.forEach(course -> {
            System.out.printf(
                    "%s | %s | %s | %s %s%n",
                    course.getCourseIdentifier(),
                    course.getCourseName(),
                    course.getSubject(),
                    course.getCourseManager().getFirstName(),
                    course.getCourseManager().getLastName());
        });
        System.out.println();
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
    private static String readStringMenuChoice(Scanner sc) {
        while (true) {
            System.out.print("> ");
            String userInput = sc.nextLine().trim();
            if (!userInput.isEmpty())
                return userInput;
            System.out.println("Please enter a text.");
        }
    }
    private static String askData(Scanner scanner, String text) {
        System.out.println(text + " : ");
        return readStringMenuChoice(scanner);
    }
}
