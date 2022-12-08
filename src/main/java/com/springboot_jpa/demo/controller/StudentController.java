package com.springboot_jpa.demo.controller;

import com.springboot_jpa.demo.domain.Student;
import com.springboot_jpa.demo.service.StudentService;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public ResponseEntity<List<Student>> getAllStudents(){

        try{
            List<Student> studentList = new ArrayList<>();

            studentList = studentService.getAllStudents();

            if(studentList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(studentList, HttpStatus.OK);
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
    public ResponseEntity<Student> addStudent(@RequestBody Student student){

        try {
            Student savedData = studentService.save(student);
            return new ResponseEntity<>(savedData, HttpStatus.OK);
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
