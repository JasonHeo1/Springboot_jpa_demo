package com.springboot_jpa.demo.repository;

import com.springboot_jpa.demo.domain.Remittance;
import com.springboot_jpa.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RemittanceRepository extends JpaRepository<Remittance, Long> {




}
