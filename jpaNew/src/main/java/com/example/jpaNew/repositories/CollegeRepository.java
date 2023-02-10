package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.College;
import com.example.jpaNew.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

    public List<College> findAll();

    public List<College> findByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId);


}
