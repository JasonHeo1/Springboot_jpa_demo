package com.springboot_jpa.demo.service;

import com.springboot_jpa.demo.domain.Card;
import com.springboot_jpa.demo.repository.CardRepository;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CardNumber {

    @Autowired
    static
    CardRepository cardRepository;

    List<String> tempClemoKeyList = new ArrayList<>();


    public static void main(String[] args) {

    }







    private static void isValidLastDigit(){

        Long cardNumber = 7410130067865627L;
//        long cardNumber = 741013006786562L;

        String cardNumberString = Long.toString(cardNumber);

        char[] chars = cardNumberString.toCharArray();

        if(chars.length < 16){
            System.out.println("Card Number length is too small");
            return;
        }

        System.out.println(chars);

        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        System.out.println("");
        System.out.println("");

        //검증코드 빼고 뒤에서부터 2와 1을 번갈아가며 곱한다.
        //7  4  1  0  1  3  0  0  6  7  8  6  5  6  2  7
        //2  1  2  1  2  1  2  1  2  1  2  1  2  1  2

        //14 4  2  0  2  3  0  0  12 7  16 6  10 6  4

        //5  4  2  0  2  3  0  0  3  7  7  6  1  6  4

        //5 + 4 + 2 + 0 + 2 + 3 + 0 + 0 + 3 + 7 + 7 + 6 + 1 + 6 + 4

        StringBuilder stringBuilder = new StringBuilder();


        for (int i = chars.length - 2; i <= chars.length; i--) {
            System.out.println("i : "+i+"    "+chars[i]);

            if(i % 2 == 0){
                int tempResult = 0;
                String num = String.valueOf(chars[i]);
                System.out.println(Integer.parseInt(num)*2);
                tempResult = Integer.parseInt(num)*2;
                if(tempResult >= 10){
                    char[] numberToChar = String.valueOf(tempResult).toCharArray();
                    int sumNum = Integer.parseInt(String.valueOf(numberToChar[0])) + Integer.parseInt(String.valueOf(numberToChar[1]));
                    System.out.println("Here is sumNum bigger than 10:   "+sumNum);
                    stringBuilder.append(sumNum);
                    System.out.println("11111   "+stringBuilder.toString());
                }else {
                    stringBuilder.append(tempResult);
                    System.out.println("22222   "+stringBuilder.toString());
                }

            }else {
                System.out.println(chars[i]);
                stringBuilder.append(chars[i]);
                System.out.println("33333   "+stringBuilder.toString());
            }

            if(i == 0){
                break;
            }

        }

        System.out.println("  ");
        System.out.println("  ");
        System.out.println(stringBuilder.reverse().toString());
    }

}
