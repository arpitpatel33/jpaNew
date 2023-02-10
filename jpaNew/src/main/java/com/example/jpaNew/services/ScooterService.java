package com.example.jpaNew.services;

import com.example.jpaNew.entities.Scooter;
import com.example.jpaNew.repositories.ScooterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScooterService {

    @Autowired
    private ScooterRepository scooterRepository;

    public List<Scooter> getAll() {

        List<Scooter> all= scooterRepository.findAll();
        return all;
    }

    public Optional<Scooter> getById(Long id) {

        Optional<Scooter> byId= scooterRepository.findById(id);
        return byId;
    }

    public List <Scooter> getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId) {
         List<Scooter> byId= scooterRepository.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return byId;
    }

    public Scooter save(Scooter scooter) {

        Scooter scooter1= scooterRepository.save(scooter);
        return scooter1;
    }

    public void deleteById(Long id) {

        scooterRepository.deleteById(id);
    }
}
