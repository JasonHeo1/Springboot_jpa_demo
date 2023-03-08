package com.springboot_jpa.demo.domain;

import com.alibaba.fastjson2.JSONObject;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@DynamicInsert
@DynamicUpdate
@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birth_of_place")
    private String birthOfPlace;

    @Column(name = "words")
    private String words;

    public Student() {
    }

    public Student(long id, String name, String gender, Integer age, String birthOfPlace) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthOfPlace = birthOfPlace;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", birthOfPlace='" + birthOfPlace + '\'' +
                '}';
    }
}
