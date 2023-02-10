package com.example.jpaNew.services;

import com.example.jpaNew.entities.Team;
import com.example.jpaNew.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAll() {

        return teamRepository.findAll();
    }

    public Optional<Team> getById(Long id) {

        return teamRepository.findById(id);
    }

    public List<Team> getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId) {

        return teamRepository.findByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
    }


    public Team save(Team team) {

        return teamRepository.save(team);
    }

    public void deleteById(Long id) {

        teamRepository.deleteById(id);

    }
}
