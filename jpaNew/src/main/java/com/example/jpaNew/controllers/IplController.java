package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Ipl;
import com.example.jpaNew.repositories.IplRepository;
import com.example.jpaNew.services.IplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ipl2023")
public class IplController {

    @Autowired
    private IplService iplService;
    @Autowired
    private IplRepository iplRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){

        List<Ipl> all= iplService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable ("id") Long id)
    {
        Optional<Ipl> byId= iplService.getById(id);
        return new ResponseEntity<>(byId,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@RequestParam ("startId") Long startId, @RequestParam ("endId") Long endId)
    {

        List<Ipl> byId= iplService.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return new ResponseEntity<>(byId,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createIpl(@RequestBody Ipl ipl){

        Ipl iplCreated= iplService.save(ipl);
        return new ResponseEntity<>(iplCreated,HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable ("id") Long id)
    {
        iplService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/update/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateById(@RequestBody Ipl ipl, @PathVariable ("id") Long id)
    {
        Ipl iplUpdate= iplService.getById(id).get();
        iplUpdate.setId(ipl.getId());
        Ipl ipl2= iplService.save(ipl);
        return new ResponseEntity<>(ipl2, HttpStatus.OK);
    }

}
