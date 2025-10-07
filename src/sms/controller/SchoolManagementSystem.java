package sms.controller;

import sms.view.SchoolManagementSystemUI;

public class SchoolManagementSystem {

    // List of students
    // List of teachers
    // List of courses
    boolean hasInitialized = false;

    public SchoolManagementSystem() {}

    public void start() {
        hasInitialized = initializeSMS();
        if (hasInitialized) {
            mainSMS();
        } else {
            System.out.println("Failed to initialize");
        }
    }

    private boolean initializeSMS() {
        // Read previously saved data
        // Store said data to lists present in this class
        return true;
    }

    private void mainSMS() {
        SchoolManagementSystemUI.printTitle();
        SchoolManagementSystemUI.startMenu();
        System.out.println("[NOT IMPLEMENTED]");
    }
}
