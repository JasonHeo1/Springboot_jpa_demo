package com.springboot_jpa.demo.repository;

import com.springboot_jpa.demo.domain.Synonym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SynonymRepository extends JpaRepository<Synonym, Long> {

    Optional<Synonym> findById(Long id);

    Optional<Synonym> findByName(String name);

    List<Synonym> findAll();

    void deleteById(Long id);


}
