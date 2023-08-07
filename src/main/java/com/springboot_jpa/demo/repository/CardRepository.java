package com.springboot_jpa.demo.repository;

import com.springboot_jpa.demo.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByClemoNo(String clemoNo);

    Optional<Card> findByClemoKey(String clemoKey);


}
