package sms.view;

import java.util.Scanner;

public class SchoolManagementSystemUI {

    public static void printTitle() {
        System.out.println("- Welcome to School Management System -");
    }

    public static void startMenu() {
        // 1. Manage students
        // 2. Manage teachers
        // 3. Manage courses
        readIntMenuChoice(new Scanner(System.in), 1, 3);
    }

    public static void manageStudentsMenu() {
        /**
         *     1. Add student
         *     2. Remove student
         *     3. Grade student
         *     4. List students
         *     5. List grades of student -> select student
         */
        readIntMenuChoice(new Scanner(System.in), 1, 5);
    }

    public static void manageTeachersMenu() {
        /**
         *     1. Add Teacher
         *     2. Remove Teacher
         *     3. List Teachers
         *     4. List courses of teacher -> select teacher
         */
        readIntMenuChoice(new Scanner(System.in), 1, 4);
    }

    public static void manageCoursesMenu() {
        /**
         *     1. Add course
         *     2. Remove course
         *     3. Add student to course
         *     4. List all courses and their course manager
         *     5. Assign course to teacher -> warn if you are replacing current teacher
         *     6. See course details -> select course -> list course name, subject, course manager, students
         */
        readIntMenuChoice(new Scanner(System.in), 1, 6);
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
