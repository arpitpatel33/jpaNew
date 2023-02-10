package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Music;
import com.example.jpaNew.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "musical_instruments")
public class MusicController {

   @Autowired
    private MusicService musicService;

   @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){

       List<Music> all= musicService.getAll();
       return new ResponseEntity<>(all, HttpStatus.OK);
   }

   @RequestMapping(method = RequestMethod.GET,value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  getById(@PathVariable ("id") Long id)
   {
       Optional<Music> byId= musicService.getById(id);
       return new ResponseEntity<>(byId, HttpStatus.OK);

   }

   @RequestMapping(method = RequestMethod.GET, value = "/id/filter",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  filterById(@RequestParam ("startId") Long startId, @RequestParam ("endId") Long endId){

       //List<Music> byId= musicService.getById
       return new ResponseEntity<>(HttpStatus.OK);
   }
}
