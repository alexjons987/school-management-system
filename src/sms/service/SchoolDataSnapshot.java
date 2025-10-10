package sms.service;

import sms.model.Course;
import sms.model.Student;
import sms.model.Teacher;

import java.util.List;

public class SchoolDataSnapshot {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;

    public SchoolDataSnapshot() {}

    public SchoolDataSnapshot(List<Student> students, List<Teacher> teachers, List<Course> courses) {
        this.students = students;
        this.teachers = teachers;
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
