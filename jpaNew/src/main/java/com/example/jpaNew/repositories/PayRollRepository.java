package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.PayRoll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayRollRepository extends JpaRepository<PayRoll, Long> {
    List<PayRoll> findAll();
}
