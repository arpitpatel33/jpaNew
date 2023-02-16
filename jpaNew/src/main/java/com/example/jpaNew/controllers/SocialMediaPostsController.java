package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.SocialMediaPosts;
import com.example.jpaNew.services.SocialMediaPostsService;
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
@RequestMapping(value = "/SocialMediaPosts")
public class SocialMediaPostsController {

    @Autowired
    private SocialMediaPostsService socialMediaPostsService;

    private static final Logger log = LoggerFactory.getLogger(SocialMediaPostsController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){

        final String methodName= "getAll() : ";
        log.info(methodName + "called : ");

        List<SocialMediaPosts> all = socialMediaPostsService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable ("id" ) Long id){

        final String methodName = "getById() : " ;
        log.info(methodName + "called ");

        Optional<SocialMediaPosts> byId = socialMediaPostsService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> filterById(@RequestParam ("startId") Long startId, @RequestParam ("endId") Long endId){

        final String methodName= "filterById() : ";
        log.info(methodName + "called");

        List<SocialMediaPosts> byId = socialMediaPostsService.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createById(@RequestBody SocialMediaPosts socialMediaPosts){

        final String methodName= "createById() : ";
        log.info(methodName + "called");

        SocialMediaPosts byId= socialMediaPostsService.save(socialMediaPosts);
        return new ResponseEntity<>(byId,HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable ("id") Long id){

        final String methodName= "deleteById : ";
        log.info(methodName + "called");

        socialMediaPostsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateById(@RequestBody SocialMediaPosts socialMediaPosts, @PathVariable ("id") Long id)
    {

        final String methodName= "updateById() : ";
        log.info(methodName + "called");

       SocialMediaPosts byId= socialMediaPostsService.findById(id);
       byId.setId(socialMediaPosts.getId());
       SocialMediaPosts updated= socialMediaPostsService.save(socialMediaPosts);
       return new ResponseEntity<>(updated,HttpStatus.OK);


    }


}
