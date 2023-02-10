package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Hotel;
import com.example.jpaNew.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll()
    {
        List<Hotel> all = hotelService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable ("id") Long id)
    {

        Optional<Hotel> byId = hotelService.getById(id);
        return new ResponseEntity<>(byId,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/id/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> filterById(@RequestParam ("startId") Long startId, @RequestParam ("endId") Long endId)
    {

        List<Hotel> byId= hotelService.getByIdGreaterThanEqualAndIdLessThanEqual(startId, endId);
        return new ResponseEntity<>(byId,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createHotel(@RequestBody Hotel hotel){

        Hotel hotelCreated= hotelService.save(hotel);
        return new ResponseEntity<>(hotelCreated,HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable ("id") Long id){

        hotelService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateById(@RequestBody Hotel hotel, @PathVariable ("id") Long id){

        Hotel byId= hotelService.getById(id).get();
        byId.setId(hotel.getId());
        Hotel hotel1= hotelService.save(hotel);
        return new ResponseEntity<>(hotel1,HttpStatus.OK);
    }

}
