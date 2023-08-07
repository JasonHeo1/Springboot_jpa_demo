package com.springboot_jpa.demo.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "card_info")
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "clemo_no")
    private String clemoNo;

    @Column(name = "clemo_key")
    private String clemoKey;

    @Column(name = "create_user")
    private long createUser;

    @Column(name = "create_date")
    private Date createDate;

}
