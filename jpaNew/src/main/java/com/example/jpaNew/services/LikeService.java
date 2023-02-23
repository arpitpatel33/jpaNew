package com.example.jpaNew.services;

import com.example.jpaNew.entities.Like;
import com.example.jpaNew.repositories.LikeRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;

@Service
public class LikeService {

    private final static Logger log= LoggerFactory.getLogger(LikeService.class);

    @Autowired
    private LikeRepository likeRepository;

    public List<Like> getAll() {

        final String methodName= "getAll() : ";
        log.info(methodName + "called");

        List<Like> all= likeRepository.findAll();
        return all;
    }

    public Optional<Like> getById(Long id) {

        final String methodName = "getById() : ";
        log.info(methodName + "called");

        Optional<Like> byId= likeRepository.findById(id);
        return byId;
    }

    public List<Like> getByIdGreaterThanEqualAndLessThanEqual(Long startId, Long endId) {

        final String methodName= "getByIdGreaterThanEqualAndLessThanEqual() : ";
        log.info(methodName + "called");

        List<Like> byId= likeRepository.getByIdGreaterThanEqualAndLessThanEqual(startId,endId);
        return byId;
    }

    public Like save(Like like) {

        final String methodName= "save() : ";
        log.info(methodName + "called");

        Like byId= likeRepository.save(like);
        return byId;
    }

    public void deleteById(Long id) {

        final String methodName= "deleteById() : ";
        log.info(methodName + "called");

        likeRepository.deleteById(id);
    }

    public Like getBySource(String source){

        Like bySource= likeRepository.getBySource(source);

    }
}
