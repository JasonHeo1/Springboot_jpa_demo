package com.springboot_jpa.demo.service;

import com.springboot_jpa.demo.domain.Student;
import com.springboot_jpa.demo.domain.StudentSecond;
import com.springboot_jpa.demo.domain.Synonym;
import com.springboot_jpa.demo.repository.StudentRepository;
import com.springboot_jpa.demo.repository.StudentSecondRepository;
import com.springboot_jpa.demo.repository.SynonymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class SynonymServiceImpl implements SynonymService{

    @Resource
    SynonymRepository synonymRepository;

    @Override
    public Optional<Synonym> findById(Long id) {
        return Optional.of(synonymRepository.findById(id)).get();
    }

    @Override
    public Optional<Synonym> findByName(String name) {
        return Optional.of(synonymRepository.findByName(name)).get();
    }

    @Override
    public List<Synonym> getAllSynonym() {
        return synonymRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        synonymRepository.deleteById(id);
    }

    @Override
    public Synonym save(Synonym synonym) {
        Synonym synonym1 = new Synonym();
//        try{
//            if(synonym1.getName().equals("iphone")) System.out.println("Here is :");
//            synonym1 = synonymRepository.save(synonym);
//            return synonym1;
//        }catch (Exception e){
////            System.out.println(e.getMessage());
//            throw new Exception(e);
//        }
        if(synonym1.getName().equals("iphone")) System.out.println("Here is :");
        synonym1 = synonymRepository.save(synonym);
        return synonym1;
    }
}
