package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Job;
import com.example.jpaNew.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "job")
public class JobController {

    @Autowired
    private JobRepository jobRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/all" , produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAll()

    {
        List<Job> all = jobRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.CREATED);
    }

    @PostMapping ("/job")
    public ResponseEntity<Object> createJob(@RequestBody Job job)
    {
        Job savedJob= jobRepository.save(job);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{jobId}")
                .buildAndExpand(savedJob.all()).toUri();
      return ResponseEntity.created(location).build() ;
    }

}
