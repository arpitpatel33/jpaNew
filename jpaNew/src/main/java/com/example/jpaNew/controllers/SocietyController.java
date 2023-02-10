package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Society;
import com.example.jpaNew.repositories.SocietyRepository;
import com.example.jpaNew.services.SocietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/society")
public class SocietyController {

    @Autowired
    private SocietyService societyService;

    @Autowired
    private SocietyRepository societyRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){

        List<Society> all= societyService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable ("id") Long id){

        Optional<Society> byId = societyService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@RequestParam ("startId") Long startId, @RequestParam ("endId") Long endId){

        if( startId== null || endId== null || startId<0 || endId<0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Society> societies = societyService.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        if( societies==null || societies.size()< 0)
        {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(societies,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTable(@RequestBody Society society){
        Society saveSociety = societyService.save(society);
        return new ResponseEntity<>(saveSociety, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateSociety(@RequestBody Society society, @PathVariable ("id") Long id) {
        Society updatedSociety = societyService.getById(id).get();
        updatedSociety.setName(society.getName());
        Society societyUpdate = societyService.save(society);
        return new ResponseEntity<>(societyUpdate, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Society> deleteById(@PathVariable ("id") Long id){

        societyRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
