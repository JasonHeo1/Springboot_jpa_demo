package com.springboot_jpa.demo.service;

import com.springboot_jpa.demo.domain.Student;
import com.springboot_jpa.demo.domain.StudentSecond;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Optional<Student> findById(Long id);

    Optional<Student> findByName(String name);

    List<Student> getAllStudents();

    void deleteById(Long id);

    Student save(Student student) throws Exception;

    StudentSecond save(StudentSecond studentSecond);


}
