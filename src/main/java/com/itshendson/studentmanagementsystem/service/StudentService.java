package com.itshendson.studentmanagementsystem.service;

import com.itshendson.studentmanagementsystem.entity.Student;
import com.itshendson.studentmanagementsystem.exception.StudentNotFoundException;
import com.itshendson.studentmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student fetchStudentById(Long studentId) {
        Optional<Student> studentRecord = studentRepository.findById(studentId);
        if (!studentRecord.isPresent()) throw new StudentNotFoundException("Student ID " + studentId + " does not exist.");
        return studentRepository.findById(studentId).get();
    }

    @Override
    public void deleteStudentById(Long studentId) {
        Optional<Student> studentRecord = studentRepository.findById(studentId);
        if (!studentRecord.isPresent()) throw new StudentNotFoundException("Student ID " + studentId + " does not exist.");
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> fetchAllStudentsByFirstName(String firstName) {
        return studentRepository.findByFirstNameIgnoreCase(firstName);
    }

    @Override
    public Student updateStudentById(Long studentId, Student student) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if (!studentOptional.isPresent()) throw new StudentNotFoundException("Student ID " + studentId + " does not exist.");;

        Student studentRecord = studentOptional.get();

        if (Objects.nonNull(student.getFirstName()) && !"".equalsIgnoreCase(student.getFirstName())) {
            studentRecord.setFirstName(student.getFirstName());
        }

        if (Objects.nonNull(student.getLastName()) && !"".equalsIgnoreCase(student.getLastName())) {
            studentRecord.setLastName(student.getLastName());
        }

        if (Objects.nonNull(student.getFaculty())) {
            studentRecord.setFaculty(student.getFaculty());
        }

        return studentRepository.save(studentRecord);
    }
}
