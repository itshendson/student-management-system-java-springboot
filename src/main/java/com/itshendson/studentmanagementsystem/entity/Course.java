package com.itshendson.studentmanagementsystem.entity;

import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String courseName;
    private String courseCode;
    private int credit;
    private double costPerCredit;
    private double totalCostOfCourse;

    public Course() {
    }

    public Course(String courseName, String courseCode, int credit, double costPerCredit) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credit = credit;
        this.costPerCredit = costPerCredit;
        this.totalCostOfCourse = credit * costPerCredit;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public double getCostPerCredit() {
        return costPerCredit;
    }

    public void setCostPerCredit(double costPerCredit) {
        this.costPerCredit = costPerCredit;
    }

    public double getTotalCostOfCourse() {
        return totalCostOfCourse;
    }

    public void setTotalCostOfCourse(double totalCostOfCourse) {
        this.totalCostOfCourse = totalCostOfCourse;
    }
}
