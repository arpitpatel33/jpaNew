package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Like;
import com.example.jpaNew.repositories.LikeRepository;
import com.example.jpaNew.repositories.PayRollRepository;
import com.example.jpaNew.services.LikeService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Like")
public class LikeController {


    @Autowired
    private LikeService likeService;
    @Autowired
    private PayRollRepository payRollRepository;

    private static final Logger log= LoggerFactory.getLogger(LikeController.class);
    @Autowired
    private LikeRepository likeRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){

        final String methodName= "getAll() : ";
        log.info(methodName + "called");

        List<Like> all= likeService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable ("id") Long id){

        final String methodName= "getById() : ";
        log.info(methodName + "called");

        Optional<Like> byId= likeService.getById(id);
        return new ResponseEntity<>(byId,HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByIdGreaterThanEqualAndLessThanEqual(@RequestParam ("startId") Long startId, @RequestParam ("endId") Long endId){

        final String methodName= "getByIdGreaterThanEqualAndLessThanEqual() : ";
        log.info(methodName + "called");

       List<Like> byId= likeService.getByIdGreaterThanEqualAndLessThanEqual(startId,endId);
       return new ResponseEntity<>(byId,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Like> createById(@RequestBody Like like){

        final String methodName= "createById() : ";
        log.info(methodName + "called");

        Like byId= likeService.save(like);
        return new ResponseEntity<>(byId,HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable ("id") Long id){

        final String methodName= "deleteById() : ";
        log.info(methodName + "called");

        likeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateById(@RequestBody Like like, @PathVariable ("id") Long id){

        final String methodName= "updateById() : ";
        log.info(methodName + "called");

        Like byId= likeService.getById(id).get();
        byId.setId(like.getId());
        Like updatedId = likeService.save(like);
        return new ResponseEntity<>(updatedId,HttpStatus.OK);
    }
}
