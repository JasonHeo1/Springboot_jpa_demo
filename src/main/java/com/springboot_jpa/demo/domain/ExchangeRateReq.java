package com.springboot_jpa.demo.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeRateReq {

    private long krw;

    private String companyCd;

    private String exchangeCurrencyCd;

    private long exchangeCurrencyPrice;

    private BigDecimal exchangeRate;

    private String state;
}
