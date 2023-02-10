package com.example.jpaNew.services;

import com.example.jpaNew.entities.Society;
import com.example.jpaNew.repositories.SocietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocietyService {

    @Autowired
    private SocietyRepository societyRepository;

    public List<Society> getAll() {

        List<Society> all = societyRepository.findAll();
        return all;
    }

    public Optional<Society> getById(Long id) {

        Optional<Society> byId = societyRepository.findById(id);
        return byId;
    }

    public List<Society> getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId) {
        List<Society> byIdGreaterThanEqualAndIdLessThanEqual = societyRepository.findByIdGreaterThanEqualAndIdLessThanEqual(startId, endId);
        return byIdGreaterThanEqualAndIdLessThanEqual;
    }


    public Society save(Society society) {

        Society societyList = societyRepository.save(society);
        return societyList;
    }


}
