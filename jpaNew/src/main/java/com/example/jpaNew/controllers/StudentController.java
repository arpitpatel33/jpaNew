package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Student;
import com.example.jpaNew.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/all" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll()
    {
        List <Student> all= studentRepository.findAll();
        return  new ResponseEntity<>(all, HttpStatus.CREATED);
    }

}
