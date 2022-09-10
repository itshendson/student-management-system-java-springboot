package com.itshendson.studentmanagementsystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    private String firstName;
    private String lastName;
    private Faculty faculty;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_Id")
    )
    private List<Course> enrolledCourses;
    private double tuitionOwed;

    public Student() {
    }

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

    public void addEnrolledCourse(Course course) {
        enrolledCourses.add(course);
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
