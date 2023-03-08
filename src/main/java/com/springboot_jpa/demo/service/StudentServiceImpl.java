package com.springboot_jpa.demo.service;

import com.springboot_jpa.demo.domain.Student;
import com.springboot_jpa.demo.domain.StudentSecond;
import com.springboot_jpa.demo.domain.Synonym;
import com.springboot_jpa.demo.repository.StudentRepository;
import com.springboot_jpa.demo.repository.StudentSecondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Resource
    SynonymService synonymService;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private StudentSecondRepository studentSecondRepository;

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
    @Transactional
    public Student save(Student student) {
        Student student1 = studentRepository.save(student);

//        String a = null;
//        if(a.equals("Here")) System.out.println("Student Here!!!");

        Synonym synonym = new Synonym();
        synonym.setName("iphone15");
        synonym.setWords("apple,imac,iphone,macintosh");
        try {
            synonymService.save(synonym);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return student1;
    }

    @Override
    public StudentSecond save(StudentSecond studentSecond) {
        return studentSecondRepository.save(studentSecond);
    }
}
