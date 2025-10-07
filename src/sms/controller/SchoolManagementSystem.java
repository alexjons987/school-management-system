package sms.controller;

import sms.model.Course;
import sms.model.Student;
import sms.model.Teacher;
import sms.view.SchoolManagementSystemUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException();
        }

    }

    private void mainSMS() {
        boolean flag = true;
        SchoolManagementSystemUI.printTitle();
        while (flag) {
            flag = SchoolManagementSystemUI.startMenu();
        }
        System.out.println("Goodbye!");
        // TODO: Save data to JSON database
    }
}
