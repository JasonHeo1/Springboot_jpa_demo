package com.springboot_jpa.demo.service;

import com.springboot_jpa.demo.domain.ExchangeCurrencyInfo;
import com.springboot_jpa.demo.domain.ExchangeRateReq;
import com.springboot_jpa.demo.domain.Remittance;
import com.springboot_jpa.demo.domain.RemittanceReq;
import com.springboot_jpa.demo.repository.ExchangeCurrencyRepository;
import com.springboot_jpa.demo.repository.RemittanceRepository;
import com.springboot_jpa.demo.utils.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RemittanceServiceImpl implements RemittanceService{

    @Resource
    RemittanceRepository remittanceRepository;

    @Resource
    ExchangeCurrencyRepository exchangeCurrencyRepository;

    @Resource
    RedisUtil redisUtil;


    @Transactional
    @Override
    public void remittanceRegister(RemittanceReq remittanceReq) {
        Remittance remittance = new Remittance();
        BeanUtils.copyProperties(remittanceReq, remittance);
        remittance.setCreatedUserId(100);
        remittance.setCreatedDate(new Date());
        remittance.setModifiedUserId(100);
        remittance.setModifiedDate(new Date());
        //insert REMITTANCE
        remittanceRepository.save(remittance);

        //insert EXCHANGE_CURRENCY_INFO
        List<ExchangeCurrencyInfo> exchangeCurrencyInfos = new ArrayList<>();
        remittanceReq.getExchangeRateReqList()
                .forEach(item -> {
                    ExchangeCurrencyInfo exchangeCurrencyInfo = new ExchangeCurrencyInfo();
                    BeanUtils.copyProperties(item, exchangeCurrencyInfo);
                    exchangeCurrencyInfo.setCompanyCd(remittance.getCompanyCd());
                    exchangeCurrencyInfos.add(exchangeCurrencyInfo);
                });

        exchangeCurrencyRepository.saveAll(exchangeCurrencyInfos);
    }

    @Override
    public List<RemittanceReq> getRemittanceList() {
        List<RemittanceReq> remittanceReqList = new ArrayList<>();
        List<ExchangeRateReq> exchangeRateReqList = new ArrayList<>();

        List<ExchangeCurrencyInfo> exchangeCurrencyInfoList = exchangeCurrencyRepository.findAll();
        exchangeCurrencyInfoList.forEach(item -> {
            ExchangeRateReq exchangeRateReq = new ExchangeRateReq();
            BeanUtils.copyProperties(item, exchangeRateReq);
            exchangeRateReqList.add(exchangeRateReq);
        });

        HashMap<String, List<ExchangeRateReq>> groupingData = exchangeRateReqList.stream()
                .collect(Collectors.groupingBy(ExchangeRateReq::getCompanyCd, HashMap::new, Collectors.toList()));


        List<Remittance> remittanceList = remittanceRepository.findAll();
        remittanceList.forEach(item -> {
            RemittanceReq remittanceReq = new RemittanceReq();
            BeanUtils.copyProperties(item, remittanceReq);
            groupingData.keySet().forEach(key -> {
                if(key.equals(remittanceReq.getCompanyCd())){{
                    remittanceReq.setExchangeRateReqList(groupingData.get(key));
                }}
            });
            remittanceReqList.add(remittanceReq);
        });

        redisUtil.set("remittanceInfo",remittanceReqList);

        return null;
    }
}
