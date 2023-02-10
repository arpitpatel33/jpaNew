package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId);

}
