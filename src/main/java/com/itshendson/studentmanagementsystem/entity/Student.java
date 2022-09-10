package com.itshendson.studentmanagementsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    public Student(String firstName, String lastName, Faculty faculty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
        this.enrolledCourses = new ArrayList<>();
        this.tuitionOwed = 0;
    }
}
