package com.example.jpaNew.services;

import com.example.jpaNew.entities.Mobile;
import com.example.jpaNew.repositories.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobileService {

    @Autowired
    private MobileRepository mobileRepository;

    public List<Mobile> getAll() {

        List<Mobile> all = mobileRepository.findAll();
        return all;
    }

    public Optional<Mobile> getById(Long id) {

        Optional<Mobile> byId= mobileRepository.findById(id);
        return byId;
    }

    public List<Mobile> getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId) {

        List<Mobile> byId= mobileRepository.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return byId;
    }

    public Mobile save(Mobile mobile) {

        Mobile mobile1= mobileRepository.save(mobile);
        return mobile1;
    }

    public void deleteById(Long id) {

        mobileRepository.deleteById(id);
    }
}
