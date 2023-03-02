package com.springboot_jpa.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Student")
public class StudentSecond {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birth_of_place")
    private String birthOfPlace;

    @Column(name = "cn_words")
    private String cnWords;

    @Column(name = "ko_words")
    private String koWords;

    @Column(name = "en_words")
    private String enWords;

    public StudentSecond() {
    }

    public StudentSecond(long id, String name, String gender, Integer age, String birthOfPlace) {
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
