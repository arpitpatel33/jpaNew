package com.example.jpaNew.services;

import com.example.jpaNew.entities.Ipl;
import com.example.jpaNew.repositories.IplRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IplService {

    @Autowired
    private IplRepository iplRepository;

    public List<Ipl> getAll() {

        List<Ipl> iplList= iplRepository.findAll();
        return iplList;
    }

    public Optional<Ipl> getById(Long id) {

        Optional<Ipl> list= iplRepository.findById(id);
        return  list;
    }

    public List<Ipl> getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId) {

        return iplRepository.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
    }


    public void deleteById(Long id) {

        iplRepository.deleteById(id);
    }

    public Ipl save(Ipl ipl) {

        return iplRepository.save(ipl);
    }
}
