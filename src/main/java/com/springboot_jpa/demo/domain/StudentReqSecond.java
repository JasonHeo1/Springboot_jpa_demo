package com.springboot_jpa.demo.domain;

import lombok.Data;

import java.util.List;

@Data
public class StudentReqSecond {

    private String name;

    private String gender;

    private Integer age;

    private String birthOfPlace;

    private List<String> cnWords;

    private List<String> koWords;

    private List<String> enWords;
}
