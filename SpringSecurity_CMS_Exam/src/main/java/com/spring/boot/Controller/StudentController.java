package com.spring.boot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.model.Student;
import com.spring.boot.service.StudentServices;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentServices service;

    @PostMapping("/saveStudent")
    public ResponseEntity<String> saveStudent( @RequestBody Student student){
        Student id = service.saveStudent(student);
        return  new ResponseEntity<String>("Student with '"+id+"' has been saved", HttpStatus.OK);

    }
    @GetMapping("/studentList")
    public ResponseEntity<List<Student>> getAllStudentDetails(){
        List<Student> list = service.getAllStudent();
        return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById( @PathVariable("id")  Integer id){
        Student std = service.getStudentById(id);
        return new ResponseEntity<Student>(std,HttpStatus.OK);
    }
    @PutMapping("/updateStudent")
    public ResponseEntity<String> updateStudent( @PathVariable("id") Integer id,  @RequestBody Student student){
        Student stdFromDb = service.getStudentById(id);
        stdFromDb.setRegNo(student.getRegNo());
        stdFromDb.setTeacher(student.getTeacher());
        stdFromDb.setClassInfo(student.getClassInfo());
        Student id1 = service.saveStudent(stdFromDb);
        return new ResponseEntity<String>("Student with '"+id1+"' has been updated",HttpStatus.OK);

    }
    @DeleteMapping("deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer id){
        service.deleteStudentById(id);
        return new ResponseEntity<String>("Student with '"+id+"' has been deleted",HttpStatus.OK);
    }
}