package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Statement;
import com.example.jpaNew.services.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/statement")
public class StatementController {

    @Autowired
    private StatementService statementService;;

    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll()
    {
        List<Statement> all= statementService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable ("id") Long id)
    {
        Optional<Statement> byId= statementService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/filter" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> filterById(@RequestParam ("startId") Long startId, @RequestParam ("endId") Long endId)
    {
        List<Statement> byId= statementService.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return new ResponseEntity<>(byId, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createById(@RequestBody Statement statement)
    {
        final String methodName = "createById() : ";
        System.out.println(methodName  + "called");
        Statement createdStatement= statementService.save(statement);
        return new ResponseEntity<>(createdStatement,HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> processTransaction(@RequestBody Statement statement)
    {
        final String methodName = "processTransaction() : ";
        System.out.println(methodName  + "called");
        Statement processTransaction= statementService.processTransaction(statement);
        return new ResponseEntity<>(processTransaction,HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateById(@RequestBody Statement statement, @PathVariable ("id") Long id){

        Statement statementUpdate= statementService.getById(id).get();
        statementUpdate.setId(statement.getId());
        Statement updatedStatement= statementService.save(statement);
        return new ResponseEntity<>(updatedStatement,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable ("id") Long id){

        statementService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
