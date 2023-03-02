package com.springboot_jpa.demo.controller;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.springboot_jpa.demo.domain.*;
import com.springboot_jpa.demo.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class StudentController {

    private static final String ID = "id";
    private static final String NAME = "name";

    @Autowired
    StudentService studentService;

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentResp>> getAllStudents(){

        try{
            List<Student> studentList = new ArrayList<>();

            studentList = studentService.getAllStudents();

            if(studentList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            List<StudentResp> studentResps = new ArrayList<>();

            StudentResp studentResp;

            for (Student student : studentList){
                studentResp = new StudentResp();
                BeanUtils.copyProperties(student, studentResp);
                if(student.getWords() != null){
                    JSONObject jsonObject = JSONObject.parse(student.getWords());
                    studentResp.setKoWords(Arrays.asList(StringUtils.split(jsonObject.getString("ko"), ",")));
                    studentResp.setCnWords(Arrays.asList(StringUtils.split(jsonObject.getString("cn"), ",")));
                    studentResp.setEnWords(Arrays.asList(StringUtils.split(jsonObject.getString("en"), ",")));
                }
                studentResps.add(studentResp);
            }

            return new ResponseEntity<>(studentResps, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getStudentById")
    public ResponseEntity<Student> getStudentById(@RequestParam("id")Long id){

        Optional<Student> student = studentService.findById(id);

        if(student.isPresent()){
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getStudentByName")
    public ResponseEntity<Student> getStudentByName(@RequestParam(NAME)String name){

        Optional<Student> student = studentService.findByName(name);

        if(student.isPresent()){
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody StudentReq studentReq){

        try {

            Student student = new Student();

            String jsonData = JSONObject.toJSONString(studentReq.getWords());

            BeanUtils.copyProperties(studentReq, student);
            student.setWords(jsonData);
//            student.setWords(studentReq.getWords().toString());

            Student savedData = studentService.save(student);
            return new ResponseEntity<>(savedData, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addStudentSecond")
    public ResponseEntity<StudentSecond> addStudent(@RequestBody StudentReqSecond studentReqSecond){

        try {

            StudentSecond studentSecond = new StudentSecond();

            BeanUtils.copyProperties(studentReqSecond, studentSecond);
            studentSecond.setCnWords((String)studentReqSecond.getCnWords().toString());
            studentSecond.setKoWords((String)studentReqSecond.getKoWords().toString());
            studentSecond.setEnWords((String)studentReqSecond.getEnWords().toString());
            StudentSecond savedSecondData = studentService.save(studentSecond);
            return new ResponseEntity<>(savedSecondData, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<HttpStatus> deleteById(@RequestParam(ID)Long id){
        try{
            studentService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
