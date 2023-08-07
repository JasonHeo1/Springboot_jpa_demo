package com.springboot_jpa.demo.controller;


import com.springboot_jpa.demo.domain.StudentResp;
import com.springboot_jpa.demo.service.CardService;
import com.springboot_jpa.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

//    @GetMapping("/register")
    @PostMapping("/register")
    public void cardRegister(@RequestParam("cardQuantity") int cardQuantity){

        cardService.cardRegister(cardQuantity);
    }

}
