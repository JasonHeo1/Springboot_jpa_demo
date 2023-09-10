package com.springboot_jpa.demo.service;

import com.springboot_jpa.demo.domain.RemittanceReq;

import java.util.List;

public interface RemittanceService {

    void remittanceRegister(RemittanceReq remittanceReq);

    List<RemittanceReq> getRemittanceList();
}
