package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    List<Investment> findByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId);
}
