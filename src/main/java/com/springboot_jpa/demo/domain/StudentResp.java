package com.springboot_jpa.demo.domain;

import com.alibaba.fastjson2.JSONArray;
import lombok.Data;

import java.util.List;

@Data
public class StudentResp {

    private String name;

    private String gender;

    private Integer age;

    private String birthOfPlace;

    private List<String> cnWords;

    private List<String> koWords;

    private List<String> enWords;

}
