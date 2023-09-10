package com.springboot_jpa.demo.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class RemittanceReq {

    private long id;

    private String companyCd;

    private String companyNm;

    private String companyNmEng;

    private String state;

    private List<ExchangeRateReq> exchangeRateReqList;

}
