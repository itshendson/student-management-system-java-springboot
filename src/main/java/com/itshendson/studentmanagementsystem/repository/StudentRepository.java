package com.itshendson.studentmanagementsystem.repository;

import com.itshendson.studentmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstNameIgnoreCase(String firstName);
}
