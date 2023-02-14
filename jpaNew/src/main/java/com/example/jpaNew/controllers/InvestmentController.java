package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Investment;
import com.example.jpaNew.repositories.InvestmentRepository;
import com.example.jpaNew.services.InvestmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(InvestmentController.class);


    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> all(){
        final String methodName= "getAll() : ";
        log.info(methodName + "called");

        List<Investment> getAll= investmentService.findAll();
        return new ResponseEntity<>(getAll, HttpStatus.OK);

    }
    @RequestMapping(method = RequestMethod.GET,value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable ("id") Long id)
    {
        final String methodName= "getById() :";
        log.info(methodName + "called");

        Optional<Investment> byId= investmentService.findById(id);
        return new ResponseEntity<>(byId,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/filter",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByFilter(@RequestParam ("startId") Long startId, @RequestParam ("endId") Long endId)
    {
        final String methodName= "getByFilter() : ";
        log.info(methodName + "called");

        List<Investment> byFilter= investmentService.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return new ResponseEntity<>(byFilter,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createById(@RequestBody Investment investment)
    {
        final String methodName= "createById() : ";
        log.info(methodName + "called");

        Investment byId= investmentService.save(investment);
        return new ResponseEntity<>(byId, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/investment",produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<?> processInvestment(@RequestBody Investment investment){

        final String methodName = "processInvestment() : ";
        System.out.println(methodName + "called");
        Investment processInvestment= investmentService.processInvestment(investment);
        return new ResponseEntity<>(processInvestment,HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable ("id") Long id)
    {
        final String methodName = "deleteById() : ";
        log.info(methodName + "called");

        investmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateById(@RequestBody Investment investment, @PathVariable ("id") Long id)
    {
     final String methodName = "updateById() : " ;
     log.info(methodName + "called");

     Investment byId= investmentService.getById(id);
     byId.setId(investment.getId());
     Investment updated= investmentService.save(investment);
     return new ResponseEntity<>(updated,HttpStatus.OK);

    }
}
