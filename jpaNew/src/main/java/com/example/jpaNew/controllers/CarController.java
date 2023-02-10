package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Car;
import com.example.jpaNew.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll()
    {

        List<Car> all= carService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable ("id") Long id){
        if(id== null || id<0){

            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        Optional<Car> byId= carService.getById(id);
        return new ResponseEntity<>(byId,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/filter",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByStartAndEndId(@RequestParam ("startId") Long startId, @RequestParam ("endId") Long endId)
    {
        if(startId== null || startId<0 || endId== null || endId<0){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Car> byStartAndEndId= carService.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return new ResponseEntity<>(byStartAndEndId,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCar(@RequestBody Car car ){

        Car carCreated= carService.save(car);
        return new ResponseEntity<>(carCreated, HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable ("id") Long id){

        carService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateId(@RequestBody Car car, @PathVariable ("id") Long id)
    {

        Car updated= carService.getById(id).get();
        updated.setId(car.getId());
        Car car1= carService.save(car);
        return new ResponseEntity<>(car1, HttpStatus.OK);
    }


}
