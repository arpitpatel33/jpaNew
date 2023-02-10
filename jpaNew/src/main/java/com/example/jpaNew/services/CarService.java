package com.example.jpaNew.services;

import com.example.jpaNew.entities.Car;
import com.example.jpaNew.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll() {

        List<Car> all= carRepository.findAll();
        return all;
    }

    public Optional<Car> getById(Long id) {

        return carRepository.findById(id);
    }

    public List<Car> getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId) {

        return carRepository.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
    }

    public Car save(Car car) {

        Car car1= carRepository.save(car);
        return car1;
    }

    public void deleteById(Long id) {

        carRepository.deleteById(id);
    }

    public long deleteByIdWithCount(Long id) {
        long count = 0;;
        count = carRepository.countById(id);
        carRepository.deleteById(id);
        return count;
    }

    public List<Car> getByFuel(String fuel){

        List<Car> byFuel = carRepository.findByFuel(fuel);

        return byFuel;
    }
}
