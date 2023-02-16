package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Comments;
import com.example.jpaNew.services.CommentsService;
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
@RequestMapping(value = "/Comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    private static final Logger log= LoggerFactory.getLogger(CommentsController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){

        final String methodName= "getAll() : ";
        log.info(methodName + "called");

        List<Comments> all= commentsService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable ("id") Long id){

        final String methodName= "getById() : ";
        log.info(methodName +"called");

        Optional<Comments> byId = commentsService.getById(id);
        return new ResponseEntity<>(byId,HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByFilter(@RequestParam ("startId") Long startId, @RequestParam ("endId") Long endId){

        final String methodName= "getByFilter() : ";
        log.info(methodName + "called");

        Comments byFilter= commentsService.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return new ResponseEntity<>(byFilter,HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createById(@RequestBody Comments comments){

        final String methodName= "createById() : ";
        log.info(methodName + "called");

        Comments byId = commentsService.save(comments);
        return new ResponseEntity<>(byId,HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable ("id") Long id){

        final String methodName= "deleteById() : ";
        log.info(methodName + "called");

        commentsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateById(@RequestBody Comments comments, @PathVariable ("id") Long id){

        final String methodName= "updateById() : ";
        log.info(methodName + "called");

        Comments byId= commentsService.getById(id).get();
        byId.setId(comments.getId());
        Comments updated= commentsService.save(comments);
        return new ResponseEntity<>(updated,HttpStatus.OK);

    }
}
