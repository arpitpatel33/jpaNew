package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Mobile;
import com.example.jpaNew.services.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/mobile")
public class MobileController {

    @Autowired
    private MobileService mobileService;

    @RequestMapping(method = RequestMethod.GET, value = "/id/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> filterById(@RequestParam("startId") Long startId, @RequestParam("endId") Long endId) {

        List<Mobile> byId = mobileService.getByIdGreaterThanEqualAndIdLessThanEqual(startId, endId);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createById(@RequestBody Mobile mobile) {
        Mobile mobile1 = mobileService.save(mobile);
        return new ResponseEntity<>(mobile1, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable ("id") Long id)
    {
        mobileService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/update/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateById(@RequestBody Mobile mobile, @PathVariable ("id") Long id)
    {
        Mobile mobile1= mobileService.getById(mobile.getId()).get();
        mobile1.setId(mobile.getId());
        Mobile mobileUpdated= mobileService.save(mobile);
        return new ResponseEntity<>(mobileUpdated, HttpStatus.OK);

    }
}
