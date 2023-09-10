package com.springboot_jpa.demo.controller;

import com.alibaba.fastjson2.JSONObject;
import com.springboot_jpa.demo.domain.RemittanceReq;
import com.springboot_jpa.demo.domain.Student;
import com.springboot_jpa.demo.domain.StudentResp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/remittance")
public class RemittanceController {

    @GetMapping("/getAllRemittanceInfo")
    public ResponseEntity<List<RemittanceReq>> getAllRemittanceInfo(){

//        try{
//            List<RemittanceReq> remittanceReqList = new ArrayList<>();
//
//            studentList = studentService.getAllStudents();
//
//            if(studentList.isEmpty()){
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            List<StudentResp> studentResps = new ArrayList<>();
//
//            StudentResp studentResp;
//
//            for (Student student : studentList){
//                studentResp = new StudentResp();
//                BeanUtils.copyProperties(student, studentResp);
//                if(student.getWords() != null){
//                    JSONObject jsonObject = JSONObject.parse(student.getWords());
//                    studentResp.setKoWords(Arrays.asList(StringUtils.split(jsonObject.getString("ko"), ",")));
//                    studentResp.setCnWords(Arrays.asList(StringUtils.split(jsonObject.getString("cn"), ",")));
//                    studentResp.setEnWords(Arrays.asList(StringUtils.split(jsonObject.getString("en"), ",")));
//                }
//                studentResps.add(studentResp);
//            }
//
//            return new ResponseEntity<>(studentResps, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        return null;
    }

}
