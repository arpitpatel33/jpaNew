package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.School;
import com.example.jpaNew.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/school")
public class SchoolController {


    @Autowired
    private SchoolRepository schoolRepository;

    @RequestMapping(method = RequestMethod.GET , value = "/all" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll()
    {
        List<School> all = schoolRepository.findAll();
        return new ResponseEntity<>(all , HttpStatus.OK);
    }

    @RequestMapping( method = RequestMethod.GET , value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable ("id") long id)
    {
    Optional<School> byId = schoolRepository.findById(id);
    return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET , value = "/id/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByStartId(@RequestParam ("startId") Long startId, @RequestParam ("endId") Long endId){

        if (startId== null || startId<0 || endId==null || endId<0){

          return new   ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<School> list = schoolRepository.findByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createSchool(@RequestBody School school){

        School schoolSaved= schoolRepository.save(school);
        return new ResponseEntity<>(schoolSaved, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable ("id") Long id){

        schoolRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateSchool(@RequestBody School school, @PathVariable Long id){

     School schoolUpdate= schoolRepository.findById(id).get();
     schoolUpdate.setStudents(school.getStudents());
     School schoolUpdated = schoolRepository.save(school);
     return new ResponseEntity<>(schoolUpdated, HttpStatus.OK);

    }
}
