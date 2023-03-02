package com.springboot_jpa.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
public class StudentReq {

    private String name;

    private String gender;

    private Integer age;

    private String birthOfPlace;

    private Words words;
}
