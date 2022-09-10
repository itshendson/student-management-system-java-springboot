package com.itshendson.studentmanagementsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String courseName;
    private String courseCode;
    private int credit;
    @ManyToMany(mappedBy = "enrolledCourses")
    private List<Student> studentsEnrolled;
    private double costPerCredit;
    private double totalCostOfCourse;

    public Course(String courseName, String courseCode, int credit, double costPerCredit) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credit = credit;
        this.costPerCredit = costPerCredit;
        this.totalCostOfCourse = credit * costPerCredit;
    }
}
