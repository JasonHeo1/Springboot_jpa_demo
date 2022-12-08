package com.springboot_jpa.demo.repository;

import com.springboot_jpa.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findById(Long id);

    Student findByName(String name);

    List<Student> findAll();

    void deleteById(Long id);


}
