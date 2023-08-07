package com.springboot_jpa.demo.service;

import com.springboot_jpa.demo.domain.Card;
import com.springboot_jpa.demo.repository.CardRepository;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService{

    @Autowired
    CardRepository cardRepository;

    private List<String> tempClemoKeyList = new ArrayList<>();

    @Transactional
    @Override
    public void cardRegister(int cardQuantity) {

        List<Card> cards = new ArrayList<>();
        tempClemoKeyList.clear();

        for (int i = 0; i < cardQuantity; i++) {
            cards.add(generateCardNumber());
        }

        cardRepository.saveAll(cards);

    }

    private Card generateCardNumber(){

//        int clemoNo = RandomUtils.nextInt(0, 1000000);

        String clemoNo = "clemoNo";
        String clemoKey = generateClemoKey();

        Card card = new Card();
        card.setClemoNo(clemoNo);
        card.setClemoKey(clemoKey);
        card.setCreateUser(1000L);

        return card;
    }

    private String generateClemoKey(){
        String newClemoKey = "";

        String clemoKey = String.valueOf(RandomUtils.nextInt(0, 100));

        Optional<Card> card = cardRepository.findByClemoKey(clemoKey);
        if(card.isPresent() || tempClemoKeyList.contains((clemoKey))){
            return generateClemoKey();
        }
        newClemoKey = clemoKey;

        tempClemoKeyList.add(newClemoKey);

        return newClemoKey;
    }
}
