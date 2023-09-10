package com.springboot_jpa.demo.repository;

import com.springboot_jpa.demo.domain.ExchangeCurrencyInfo;
import com.springboot_jpa.demo.domain.Remittance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeCurrencyRepository extends JpaRepository<ExchangeCurrencyInfo, Long> {




}
