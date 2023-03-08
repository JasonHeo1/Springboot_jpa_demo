package com.springboot_jpa.demo.domain;

import lombok.Data;

@Data
public class StudentUpdateReq {

    private Long id;

    private String name;

    private String gender;

    private Integer age;

    private String birthOfPlace;

    private Words words;
}
