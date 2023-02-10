package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Test;
import com.example.jpaNew.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/all/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        List<Test> all = testRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.CREATED);


    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{x}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable("x") long y) {
        Optional<Test> byId = testRepository.findById(y);
        return new ResponseEntity<>(byId.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/search/id", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getCustomBill(@RequestParam("startId") Long startId,@RequestParam("endId") Long endId) {

        List<Test> testList = testRepository.findByIdGreaterThanEqualAndIdLessThanEqual(startId, endId);

        return new ResponseEntity<>(testList, HttpStatus.OK);
    }
}

