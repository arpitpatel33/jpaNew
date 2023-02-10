package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository <School, Long> {

  public List<School> findAll();


 public List<School> findByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId);


}
