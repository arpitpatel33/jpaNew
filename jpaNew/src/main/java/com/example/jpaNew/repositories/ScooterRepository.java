package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScooterRepository extends JpaRepository<Scooter,Long> {
   List <Scooter> getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId);
}
