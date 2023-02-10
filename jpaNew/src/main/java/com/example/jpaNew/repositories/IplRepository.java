package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.Ipl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IplRepository extends JpaRepository<Ipl,Long> {
    List<Ipl> getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId);
}
