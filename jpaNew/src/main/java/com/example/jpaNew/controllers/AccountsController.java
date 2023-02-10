package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Accounts;
import com.example.jpaNew.services.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/accounts")
public class AccountsController {

    @Autowired
    private AccountsService accountsService;

    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){

        List<Accounts> all= accountsService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable ("id") Long id){

        Optional<Accounts> byId= accountsService.getById(id);
        return new ResponseEntity<>(byId,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/id/filter",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> filterById(@RequestParam ("startId") Long startId, @RequestParam ("endId") Long endId)
    {
        Accounts byId= accountsService.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return new ResponseEntity<>(byId,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Accounts> createId(@RequestBody Accounts accounts)
    {

        Accounts createById= accountsService.save(accounts);
        return new ResponseEntity<>(createById,HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable ("id") Long id)
    {
        accountsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.PUT,value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateById(@RequestBody Accounts accounts, @PathVariable ("id") Long id)
    {
        Accounts accountUpdated = accountsService.getById(id).get();
        accountUpdated.setId(accounts.getId());
        Accounts updatedAccount= accountsService.save(accounts);
        return new ResponseEntity<>(updatedAccount,HttpStatus.OK);

    }
}
