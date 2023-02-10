package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Team;
import com.example.jpaNew.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(method = RequestMethod.GET, value = "/id/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByStartIdAndEndId(@RequestParam ("startId") Long startId, @RequestParam ("endId") Long endId){
        List<Team> byStartIdAndEndId= teamService.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return new ResponseEntity<>(byStartIdAndEndId, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTeam(@RequestBody Team team)
    {
        Team teamCreated= teamService.save(team);
        return new ResponseEntity<>(teamCreated,HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable ("id") Long id){

        teamService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateById(@RequestBody Team team , @PathVariable ("id") Long id){

        Team teamUpdate= teamService.getById(id).get();
        teamUpdate.setId(team.getId());
        Team teamUpdated = teamService.save(team);
        return new ResponseEntity<>(teamUpdated,HttpStatus.OK);
    }
}
