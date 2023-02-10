package com.example.jpaNew.services;

import com.example.jpaNew.entities.Music;
import com.example.jpaNew.repositories.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public List<Music> getAll() {

        List<Music> all= musicRepository.findAll();
        return all;
    }

    public Optional<Music> getById(Long id) {

        Optional<Music> byId= musicRepository.findById(id);
        return byId;
    }
}
