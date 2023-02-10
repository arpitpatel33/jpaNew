package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Scooter;
import com.example.jpaNew.services.ScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/scooter")
public class ScooterController {

    @Autowired
    private ScooterService scooterService;

    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){

        List<Scooter> all = scooterService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable ("id") Long id)
    {
        Optional<Scooter> byId= scooterService.getById(id);
        return new ResponseEntity<>(byId,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByIdFilter(@RequestParam ("startId") Long startId, @RequestParam ("endId") Long endId){

        List<Scooter> byId= scooterService.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createScooter(@RequestBody Scooter scooter){

        Scooter scooter1= scooterService.save(scooter);
        return new ResponseEntity<>(scooter1,HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable ("id") Long id){

        scooterService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateById(@RequestBody Scooter scooter, @PathVariable ("id") Long id)
    {
        Scooter scooter1= scooterService.getById(id).get();
        scooter1.setId(scooter1.getId());
        Scooter scooterUpdated= scooterService.save(scooter);
        return new ResponseEntity<>(scooterUpdated,HttpStatus.OK);

    }
}
