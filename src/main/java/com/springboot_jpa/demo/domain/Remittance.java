package com.springboot_jpa.demo.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "REMITTANCE_APP")
@Data
public class Remittance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "COMPANY_CD")
    private String companyCd;

    @Column(name = "COMPANY_NM")
    private String companyNm;

    @Column(name = "COMPANY_NM_ENG")
    private String companyNmEng;

    @Column(name = "STATE")
    private String state;

    @Column(name = "CREATED_USER_ID")
    private long createdUserId;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "MODIFIED_USER_ID")
    private long modifiedUserId;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

}
