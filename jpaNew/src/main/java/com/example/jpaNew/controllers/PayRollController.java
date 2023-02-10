package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.PayRoll;
import com.example.jpaNew.repositories.PayRollRepository;
import com.example.jpaNew.services.PayRollServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PayRollController {

    @Autowired
    private PayRollRepository payRollRepository;
    @Autowired
    private PayRollServiceInterface payRollServiceInterface;

    @GetMapping("/payroll")
    public List<PayRoll> retrieveAll() {
        return payRollRepository.findAll();
    }

    @PostMapping("/payroll")
    public ResponseEntity<PayRoll> createPayRoll(@RequestBody PayRoll payRoll) {

        PayRoll payRollSaved = payRollServiceInterface.createPayRoll(payRoll);

        return new ResponseEntity<PayRoll>(payRollSaved, HttpStatus.CREATED);
    }


}
