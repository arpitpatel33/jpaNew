package com.example.jpaNew.services;


import com.example.jpaNew.entities.Comments;
import com.example.jpaNew.entities.SocialMediaPosts;
import com.example.jpaNew.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    public List<Comments> getAll() {

        List<Comments> all = commentsRepository.findAll();
        return all;
    }

    public Optional<Comments> getById(Long id) {

        Optional<Comments> byId= commentsRepository.findById(id);
        return byId;
    }

    public Comments getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId) {

        Comments byId= commentsRepository.findByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return byId;
    }

    public Comments save(Comments comments) {

        Comments byId= commentsRepository.save(comments);
        return byId;
    }

    public void deleteById(Long id) {

        commentsRepository.deleteById(id);
    }




}
