package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Long> {
    List<Statement> getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId);

    ;
}
