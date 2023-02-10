package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.College;
import com.example.jpaNew.repositories.CollegeRepository;
import com.example.jpaNew.services.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private CollegeRepository collegeRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {

        List<College> all = collegeService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable ("id") long id){

        Optional<College> byId = collegeService.getById(id);

            if (!byId.isPresent()){

                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
            return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByStartId(@RequestParam ("startId") Long startId, @RequestParam ("endId") Long endId)
    {
        if( startId==null || endId==null || startId<0 || endId<0){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<College> collegeList = collegeService.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        if (collegeList== null || collegeList.size() < 0)
        {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(collegeList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCollege(@RequestBody College college){

        College collegeSaved= collegeRepository.save(college);
        return new ResponseEntity<>(collegeSaved, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<College> deleteById(@PathVariable ("id") Long id){

        if( id==null || id<0){

            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        collegeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> replaceCollege(@RequestBody College college, @PathVariable Long id)
    {
        College collegeUpdate = collegeRepository.findById(id).get();
        collegeUpdate.setCollege_name(college.getCollege_name());
        College collegeUpdated= collegeRepository.save(college);
        return new ResponseEntity<>(collegeUpdated, HttpStatus.OK);
    }
}

