package com.example.jpaNew.services;

import com.example.jpaNew.entities.Hotel;
import com.example.jpaNew.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    public List<Hotel> getAll() {

        List<Hotel> all= hotelRepository.findAll();
        return all;
    }

    public Optional<Hotel> getById(Long id) {

        Optional byId= hotelRepository.findById(id);
        return byId;

    }

    public List<Hotel> getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId) {

        List<Hotel> allById= hotelRepository.findByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return allById;
    }

    public Hotel save(Hotel hotel) {

        Hotel hotel1= hotelRepository.save(hotel);
        return hotel1;
    }

    public void deleteById(Long id) {

        hotelRepository.deleteById(id);
    }
}
