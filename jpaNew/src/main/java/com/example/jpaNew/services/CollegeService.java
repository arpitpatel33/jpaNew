package com.example.jpaNew.services;

import com.example.jpaNew.entities.College;
import com.example.jpaNew.repositories.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    public  List<College> getAll() {

        List<College> all = collegeRepository.findAll();
        return all ;
    }

    public Optional<College> getById(long id) {

        Optional<College> byId = collegeRepository.findById(id);
        return byId;
    }

    public List<College> getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId) {

        List<College> byIdGreaterThanEqualAndIdLessThanEqual = collegeRepository.findByIdGreaterThanEqualAndIdLessThanEqual(startId, endId);
        return byIdGreaterThanEqualAndIdLessThanEqual;
    }


}
