package com.itshendson.studentmanagementsystem.model;

import java.math.BigDecimal;
import java.util.List;

public class Student {
    private Long studentId;
    private String firstName;
    private String lastName;
    private Faculty faculty;
    private List<Course> enrolledCourses;
    private double tuitionOwed;

    public Student(String firstName, String lastName, Faculty faculty, List<Course> enrolledCourses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
        this.enrolledCourses = enrolledCourses;
        this.tuitionOwed = 0;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public double getTuitionOwed() {
        return tuitionOwed;
    }

    public void setTuitionOwed(double tuitionOwed) {
        this.tuitionOwed = tuitionOwed;
    }

    private enum Faculty {
        ARTS,
        BUSINESS,
        COMMUNICATION,
        DENTISTRY,
        LAW,
        MEDICINE,
        MUSIC,
        SCIENCE
    }
}
