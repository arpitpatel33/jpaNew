package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    Accounts getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId);

    Accounts findByAccountNo(String accountNo);
}
