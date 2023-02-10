package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    public List<Transaction> findAll();

    public List<Transaction> findByAmount(Long amount);

    public List<Transaction> findByAmountGreaterThanEqualAndAmountLessThanEqual(Long startAmount, Long endAmount);

}
