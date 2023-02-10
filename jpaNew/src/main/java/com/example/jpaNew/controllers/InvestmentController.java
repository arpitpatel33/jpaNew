package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Investment;
import com.example.jpaNew.repositories.InvestmentRepository;
import com.example.jpaNew.services.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/investment")
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;
    @Autowired
    private InvestmentRepository investmentRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> all(){

        List<Investment> getAll= investmentService.findAll();
        return new ResponseEntity<>(getAll, HttpStatus.OK);

    }
    @RequestMapping(method = RequestMethod.GET,value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable ("id") Long id)
    {
        Optional<Investment> byId= investmentService.findById(id);
        return new ResponseEntity<>(byId,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/filter",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByFilter(@RequestParam ("startId") Long startId, @RequestParam ("endId") Long endId)
    {
        List<Investment> byFilter= investmentService.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return new ResponseEntity<>(byFilter,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createById(@RequestBody Investment investment)
    {
        Investment byId= investmentService.save(investment);
        return new ResponseEntity<>(byId, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable ("id") Long id)
    {
        investmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateById(@RequestBody Investment investment, @PathVariable ("id") Long id)
    {
     Investment byId= investmentService.getById(id);
     byId.setId(investment.getId());
     Investment updated= investmentService.save(investment);
     return new ResponseEntity<>(updated,HttpStatus.OK);

    }
}
