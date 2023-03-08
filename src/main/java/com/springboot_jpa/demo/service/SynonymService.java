package com.springboot_jpa.demo.service;

import com.springboot_jpa.demo.domain.Student;
import com.springboot_jpa.demo.domain.StudentSecond;
import com.springboot_jpa.demo.domain.Synonym;

import java.util.List;
import java.util.Optional;

public interface SynonymService {

    Optional<Synonym> findById(Long id);

    Optional<Synonym> findByName(String name);

    List<Synonym> getAllSynonym();

    void deleteById(Long id);

    Synonym save(Synonym synonym) throws Exception;

}
