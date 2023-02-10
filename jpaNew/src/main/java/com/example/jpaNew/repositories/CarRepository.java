package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId);

    public List<Car> findByFuel(String fuel);

    public long countById(Long id);
}
