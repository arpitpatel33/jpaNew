package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test,Long> {

    public List<Test> findAll();
    public List<Test> findByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId);
}
