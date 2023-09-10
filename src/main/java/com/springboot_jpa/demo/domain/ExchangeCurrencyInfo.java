package com.springboot_jpa.demo.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "EXCHANGE_CURRENCY_INFO")
@Data
public class ExchangeCurrencyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "COMPANY_CD")
    private String companyCd;

    @Column(name = "KRW")
    private long krw;

    @Column(name = "EXCHANGE_CURRENCY_CD")
    private String exchangeCurrencyCd;

    @Column(name = "EXCHANGE_CURRENCY_PRICE")
    private long exchangeCurrencyPrice;

    @Column(name = "EXCHANGE_RATE")
    private BigDecimal exchangeRate;

    @Column(name = "STATE")
    private String state;

    @Column(name = "CREATED_USER_ID")
    private long createdUserId;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "MODIFIED_USER_ID")
    private long modifiedUserId;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

}
