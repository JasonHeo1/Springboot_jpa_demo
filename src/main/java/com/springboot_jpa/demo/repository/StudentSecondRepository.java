package com.springboot_jpa.demo.repository;

import com.springboot_jpa.demo.domain.Student;
import com.springboot_jpa.demo.domain.StudentSecond;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentSecondRepository extends JpaRepository<StudentSecond, Long> {

    Optional<StudentSecond> findById(Long id);

    StudentSecond findByName(String name);

    List<StudentSecond> findAll();

    void deleteById(Long id);


}
