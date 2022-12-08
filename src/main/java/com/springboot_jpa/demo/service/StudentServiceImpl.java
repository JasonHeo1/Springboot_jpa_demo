package com.springboot_jpa.demo.service;

import com.springboot_jpa.demo.domain.Student;
import com.springboot_jpa.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.of(studentRepository.findById(id).get());
    }

    @Override
    public Optional<Student> findByName(String name) {
        return Optional.of(studentRepository.findByName(name));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
